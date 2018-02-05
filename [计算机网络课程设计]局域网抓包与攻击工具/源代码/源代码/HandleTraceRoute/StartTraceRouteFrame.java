package HandleTraceRoute;

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

public class StartTraceRouteFrame extends JFrame implements ActionListener, WindowListener {

	String host;//访问网站
	int times;//访问次数
	boolean flag = false;//同步锁
	double[] RTT;//RTT


	// 界面有关变量
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	TraceRouteTable table;
	JButton jbt_trace = new JButton("Trace");
	private final JButton jbt_route = new JButton("Route");
	private final JLabel jlb_host = new JLabel("    请输入要访问的网站：");
	private final JLabel jlb_times = new JLabel("          请输入访问次数：");
	private final JTextField jtf_host = new JTextField();
	private final JTextField jtf_times = new JTextField();

	public StartTraceRouteFrame() {
		

		this.setResizable(false);
		jtf_times.setColumns(10);
		jtf_host.setColumns(10);

		this.setTitle("TraceRoute");
		this.setSize(1040, 476);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(jpl1, BorderLayout.NORTH);
		jpl1.setLayout(new GridLayout(0, 6, 10, 30));

		jpl1.add(jlb_host);

		jpl1.add(jtf_host);

		jpl1.add(jlb_times);

		jpl1.add(jtf_times);

		jpl1.add(jbt_trace);

		jpl1.add(jbt_route);

		jbt_trace.addActionListener(this);
		jbt_route.addActionListener(this);

		getContentPane().add(jpl2, BorderLayout.CENTER);
		jpl2.setLayout(new BorderLayout(0, 0));

		table = new TraceRouteTable();
		table.setOpaque(true);
		jpl2.add(table);

		this.setLocation(200, 130);
		this.setVisible(true);

		this.addWindowListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if (e.getSource() == jbt_trace) {
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
			this.setTitle("TraceRoute(已开始)");
	
			
		
			

			try {
					//开多线程
				new Thread(){
					public void run() {
						try {
							String fileName ="Traceroute.txt";
							PrintStream ps = new PrintStream(new FileOutputStream(fileName, false));
							//调用控制台命令
							Runtime rt = Runtime.getRuntime();
							Process pro = rt.exec("traceroute -I -q " + times + " " + host);
							BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
							String line;
							while ((line = buf.readLine()) != null) {
								table.InsertRow(line);
								ps.println(line);
							}
							ps.close();
						
						
						
						flag = true;//解开同步锁
						setTitle("TraceRoute(已终止)");
						table.InsertRow("");
						table.InsertRow("");
						table.InsertRow("＝＝＝＝＝＝＝＝已终止＝＝＝＝＝＝＝＝");
						
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
		
		if(e.getSource() == jbt_route)
		{
			if(flag==false)
			{
				JOptionPane.showMessageDialog(null, "请耐心等待");
				return;
			}
			
			
			try {
		 
				
				new RouteFrame(host, TraceRoute.parse_traceroute());
				
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "出现异常："+'\n'+e1.toString());
			}


		}

	}
	
	public void setTittle(String str) {
		this.setTitle(str);
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
		new StartTraceRouteFrame();
	}

}
