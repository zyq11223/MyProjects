package HandlePing;

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

public class StartPingFrame extends JFrame implements ActionListener, WindowListener {

	String host;//访问网站
	int times;//访问次数
	boolean flag = true;//同步锁
	double[] RTT;//RTT

	// 界面有关变量
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	PingTable table;
	JButton jbt_jbt = new JButton("Ping");
	private final JButton jbt_draw = new JButton("绘图");
	private final JLabel jlb_host = new JLabel("    请输入要访问的网站：");
	private final JLabel jlb_times = new JLabel("          请输入访问次数：");
	private final JTextField jtf_host = new JTextField();
	private final JTextField jtf_times = new JTextField();

	public StartPingFrame() {
		
		
		this.setResizable(false);
		jtf_times.setColumns(10);
		jtf_host.setColumns(10);

		this.setTitle("Ping");
		this.setSize(1040, 476);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(jpl1, BorderLayout.NORTH);
		jpl1.setLayout(new GridLayout(0, 6, 10, 30));

		jpl1.add(jlb_host);

		jpl1.add(jtf_host);

		jpl1.add(jlb_times);

		jpl1.add(jtf_times);

		jpl1.add(jbt_jbt);

		jpl1.add(jbt_draw);

		jbt_jbt.addActionListener(this);
		jbt_draw.addActionListener(this);

		getContentPane().add(jpl2, BorderLayout.CENTER);
		jpl2.setLayout(new BorderLayout(0, 0));

		table = new PingTable();
		table.setOpaque(true);
		jpl2.add(table);

		this.setLocation(200, 130);
		this.setVisible(true);

		this.addWindowListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if (e.getSource() == jbt_jbt) {
			if (jtf_host.getText() == null || jtf_times.getText() == null || jtf_host.getText() == ""
					|| jtf_times.getText() == "" || jtf_host.getText().equals("") || jtf_times.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入访问网站和访问次数!");
				return;
			}

			host = jtf_host.getText();

			try {
				times = Integer.parseInt(jtf_times.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "访问次数必须为数字！");
				return;

			}

			flag = false;//设置同步锁
			table.DeleteAll();//清空列表
			Ping ping = new Ping();
			

			try {
				new Thread(){
					public void run() {
						try {
							//将结果暂存下来
						PrintStream ps = new PrintStream(new FileOutputStream("Ping.txt", false));
						//调用控制台操作
						Runtime rt = Runtime.getRuntime();
						Process pro = rt.exec("Ping -c " + times + " " + host);
						BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
						String line;
						while ((line = buf.readLine()) != null) {

							table.InsertRow(line);
							ps.println(line);
						}
						
						ps.close();
						
						
						ArrayList<Double> rtt = 	ping.run_ping(times);
						table.InsertRow("");
						table.InsertRow("");	
						//统计丢包率等信息
						String summary = "丢包率："+ping.drop_rate+"   	最大RTT："+ping.max_rtt+" ms"+"   	均值RTT："+ping.median_rtt+" ms"+"   	最小RTT："+ping.min_rtt+" ms";				
						table.InsertRow(summary);					
						RTT = new double[rtt.size()];
						int i=0;
						for(double rtt0:rtt)
							RTT[i++] = rtt0;
						
						
						flag = true;//开同步锁
						
						}
						
						
						
						catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "出现异常："+'\n'+e1.toString());
						}
					};
					}.start();




				
				
				
				
				

				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "出现异常："+'\n'+e2.toString());
			}
			

			

			

		}
		
		if(e.getSource() == jbt_draw)
		{
			if(flag==false)
			{
				JOptionPane.showMessageDialog(null, "请耐心等待");
				return;
			}

			try {
				Draw_RTT.drawRTT(host, RTT);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "绘图异常："+'\n'+e1.toString());
			}
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
		new StartPingFrame();
	}

}
