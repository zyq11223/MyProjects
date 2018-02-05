package GrabbingPacketsFrame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import JFreeChart.CategoryChart;
import JFreeChart.PieChart;
import JFreeChart.HandleDate;
import Util.JDBC;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StatisticFrame extends JFrame implements ActionListener,WindowListener{
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	
	JPanel ALL = new JPanel();
	 JPanel Protocol = new JPanel();
	 JPanel Version = new JPanel();
	
	JPanel TCP = new JPanel();
	JPanel TCP_len = new JPanel();

	JPanel UDP = new JPanel();
	JPanel UDP_TTL = new JPanel();

	JPanel ICMP = new JPanel();
	JPanel ICMP_len = new JPanel();
	JPanel TCP_TTL = new JPanel();
	JPanel UDP_len = new JPanel();
	JPanel ICMP_TTL = new JPanel();

	
	JFreeChart versionChart = PieChart.createChart("IP数据包版本统计", HandleDate.countVersion());
	JFreeChart protocolChart = PieChart.createChart("数据包类型统计", HandleDate.countProtocol());


	JFreeChart TCP_lenChart = CategoryChart.createChart("TCP数据包大小统计", HandleDate.TCPlen(),Color.RED);
	JFreeChart TCP_TTLChart = CategoryChart.createChart("TCP数据包生存期统计", HandleDate.TCPTTL(),Color.blue);


	JFreeChart UDP_lenChart = CategoryChart.createChart("UDP数据包大小统计", HandleDate.UDPlen(),Color.RED);
	JFreeChart UDP_TTLChart = CategoryChart.createChart("UDP数据包生存期统计", HandleDate.UDPTTL(),Color.blue);
	

	JFreeChart ICMP_lenChart = CategoryChart.createChart("ICMP数据包大小统计", HandleDate.ICMPlen(),Color.RED);
	JFreeChart ICMP_TTLChart = CategoryChart.createChart("ICMP数据包生存期统计", HandleDate.ICMPTTL(),Color.blue);
	

	public StatisticFrame() {
		this.setSize(1000, 800);
		this.setResizable(false);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
																tabbedPane.addTab("所有数据包", null, ALL, null);
																ALL.setLayout(new GridLayout(2, 2, 0, 0));
																
																ALL.add(Version);
																Version.setLayout(new BorderLayout(0, 0));
																ChartPanel Versionframe = new ChartPanel(versionChart);
																Version.add(Versionframe);
																
																ALL.add(Protocol);
																Protocol.setLayout(new BorderLayout(0, 0));
																ChartPanel Protocolframe = new ChartPanel(protocolChart);
																Protocol.add(Protocolframe);
																tabbedPane.addTab("TCP数据包", null, TCP, null);
																TCP.setLayout(new GridLayout(0, 2, 0, 0));
																		TCP.add(TCP_len);
																		TCP_len.setLayout(new BorderLayout(0, 0));
																		ChartPanel TCP_lenframe = new ChartPanel(TCP_lenChart);
																		TCP_len.add(TCP_lenframe);
																		
																				TCP.add(TCP_TTL);
																				TCP_TTL.setLayout(new BorderLayout(0, 0));
																				ChartPanel TCP_TTLframe = new ChartPanel(TCP_TTLChart);
																				TCP_TTL.add(TCP_TTLframe);
																				tabbedPane.addTab("UDP数据包", null, UDP, null);
																				UDP.setLayout(new GridLayout(0, 2, 0, 0));
																				
																						UDP.add(UDP_len);
																						UDP_len.setLayout(new BorderLayout(0, 0));
																						ChartPanel UDP_lenframe = new ChartPanel(UDP_lenChart);
																						UDP_len.add(UDP_lenframe);
																						UDP.add(UDP_TTL);
																						UDP_TTL.setLayout(new BorderLayout(0, 0));
																						ChartPanel UDP_TTLframe = new ChartPanel(UDP_TTLChart);
																						UDP_TTL.add(UDP_TTLframe);
																						tabbedPane.addTab("ICMP数据包", null, ICMP, null);
																						ICMP.setLayout(new GridLayout(0, 2, 0, 0));
																						ICMP.add(ICMP_len);
																						ICMP_len.setLayout(new BorderLayout(0, 0));
																						ChartPanel ICMP_lenframe = new ChartPanel(ICMP_lenChart);
																						ICMP_len.add(ICMP_lenframe);
																						ICMP.add(ICMP_TTL);
																						ICMP_TTL.setLayout(new BorderLayout(0, 0));
																						ChartPanel ICMP_TTLframe = new ChartPanel(ICMP_TTLChart);
																						ICMP_TTL.add(ICMP_TTLframe);
		
		this.setLocation(200, 130);
		this.setVisible(true);
		this.setTitle("统计结果");
		this.addWindowListener(this);

	}


	

	@Override
	public void actionPerformed(ActionEvent e) {


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
		// TODO Auto-generated method stub
		
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
