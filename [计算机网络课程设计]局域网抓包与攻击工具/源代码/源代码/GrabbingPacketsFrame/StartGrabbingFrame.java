package GrabbingPacketsFrame;

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
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
import Util.JDBC;
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

public class StartGrabbingFrame extends JFrame implements ActionListener, WindowListener {

	boolean FLAG = false;
	NetworkInterface[] devices = JpcapCaptor.getDeviceList();

	// 界面有关变量
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	PackagesTable table;
	JComboBox jcb_interface = new JComboBox();
	JButton jbt_start = new JButton("开始");
	private final JComboBox jcb_filter = new JComboBox();
	private final JButton jbt_pause = new JButton("终止");
	private final JLabel jlb_interface = new JLabel("          请选择网卡类型：");
	private final JLabel jlb_filter = new JLabel("     是否过滤（混杂模式）：");

	public StartGrabbingFrame() {
		this.setTitle("网 络 抓 包");
		this.setResizable(false);
		this.setSize(1040, 476);

		this.setLocation(200, 130);
		this.setVisible(true);

		this.addWindowListener(this);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(jpl1, BorderLayout.NORTH);
		jpl1.setLayout(new GridLayout(0, 6, 10, 30));

		jpl1.add(jlb_interface);
		jpl1.add(jcb_interface);
				

		jcb_interface.addItem("Wi-Fi：en0");
		jcb_interface.addItem("Thunderbolt Bridge：bridge0");
		jcb_interface.addItem("Thunderbolt：en1");
		jcb_interface.addItem("Apple-USB：en5");
		jcb_interface.addItem("bridge100");
		jcb_interface.addItem("Loopback：lo0");


		
		
		
		jpl1.add(jlb_filter);

		jpl1.add(jcb_filter);

		jcb_filter.addItem("是");
		jcb_filter.addItem("否");

		jpl1.add(jbt_start);

		jpl1.add(jbt_pause);

		jbt_start.addActionListener(this);
		jbt_pause.addActionListener(this);

		getContentPane().add(jpl2, BorderLayout.CENTER);
		jpl2.setLayout(new BorderLayout(0, 0));

		table = new PackagesTable();
		table.setOpaque(true);
		jpl2.add(table);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbt_start) {
			
			if(FLAG==true)
			{
				JOptionPane.showMessageDialog(this, "请先终止抓包");
				return;
			}
			FLAG = true;
			this.setTitle("网 络 抓 包   (已开始)");
			/*--------------	绑定网络设备       --------------*/
			NetworkInterface device = devices[jcb_interface.getSelectedIndex()];

			/*--------------	过滤器选择（过滤为false）       --------------*/
			boolean promiscCheck = jcb_filter.getSelectedIndex() == 1 ? true : false;

			/*--------------	抓包器参数调整       --------------*/
			try {
				JpcapCaptor jpcap = JpcapCaptor.openDevice(device, 65535, promiscCheck, 50);
				// 1.需要监听的网卡
				// 2.每次捕获的数据包最大长度（设置为IP包最大长度即可）
				// 3.过滤（Mac地址不是当前网卡的IP数据包）
				// 4.超时时间

				new Thread() {
					public void run() {
						while (FLAG) {
							try {

								Packages p = Jpcap.getPackets(jpcap);
								if (p == null)
									continue;

								table.InsertRow(p);

							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					};
				}.start();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == jbt_pause) {
			FLAG = false;
			this.setTitle("网 络 抓 包   (已终止)");
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		new GrabbingPacketsMainFrame();

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

}
