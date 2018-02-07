package MainFrame;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ARPAttack.StartARPAttackFrame;
import GrabbingPacketsFrame.GrabbingPacketsMainFrame;
import HandleJpcap.AllPackages;
import HandlePing.StartPingFrame;
import HandleTraceRoute.StartTraceRouteFrame;
import Util.JDBC;
import Util.Statistic;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements MouseListener {

	// 界面有关变量
	JPanel jpl = new JPanel();
	ImageIcon background = new ImageIcon("backgroundImage.jpg");
	JLabel backgroundImage = new JLabel(background);
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();
	JLabel jlb_grab = new JLabel("Grabbing");
	JLabel jlb_ping = new JLabel("Ping");
	JLabel jlb_traceroute = new JLabel("TraceRoute");
	JLabel jlb_hack = new JLabel("Hack");
	private final JLabel lblAllRightsReserved = new JLabel("All Rights Reserved");
	private final JLabel lblCopyright = new JLabel("Copyright ©");
	JLabel lblDesignedByZixu = new JLabel("Designed by Zixu Wang");

	public MainFrame() {

		this.setResizable(false); // 大小不可改变
		jlb_grab.addMouseListener(this);
		jlb_ping.addMouseListener(this);
		jlb_traceroute.addMouseListener(this);
		jlb_hack.addMouseListener(this);

		// 设置边界大小
		backgroundImage.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		jpl = (JPanel) this.getContentPane();
		jpl.setOpaque(false);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(backgroundImage, new Integer(Integer.MIN_VALUE));

		// 适应图片大小
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		jpl.setLayout(null);
		JLabel main_tittle = new JLabel("Network Toolbox");
		// 改变字体，下同
		Font main_font = new Font("consolas", Font.BOLD | Font.ITALIC, 38);
		main_tittle.setFont(main_font);
		jpl.add(main_tittle);

		main_tittle.setForeground(Color.WHITE);
		main_tittle.setSize(359, 54);
		main_tittle.setLocation(44, 88);

		jpl.add(jlb_grab);
		Font jlb_grab_ = new Font("consolas", Font.BOLD, 40);
		jlb_grab.setFont(jlb_grab_);
		jlb_grab.setForeground(Color.WHITE);
		jlb_grab.setSize(189, 60);
		jlb_grab.setLocation(112, 212);

		jpl.add(jlb_ping);
		Font jlb_ping_ = new Font("consolas", Font.BOLD, 40);
		jlb_ping.setForeground(Color.WHITE);
		jlb_ping.setFont(jlb_ping_);
		jlb_ping.setSize(106, 54);
		jlb_ping.setLocation(154, 307);

		jpl.add(jlb_traceroute);
		Font jlb_traceroute_ = new Font("consolas", Font.BOLD, 40);
		jlb_traceroute.setForeground(Color.WHITE);
		jlb_traceroute.setFont(jlb_traceroute_);
		jlb_traceroute.setSize(221, 60);
		jlb_traceroute.setLocation(90, 396);

		jpl.add(jlb_hack);
		Font jlb_hack_ = new Font("consolas", Font.BOLD, 40);
		jlb_hack.setForeground(Color.WHITE);
		jlb_hack.setFont(jlb_hack_);
		jlb_hack.setSize(106, 60);
		jlb_hack.setLocation(154, 486);

		Font little = new Font("consolas", Font.ITALIC, 12);

		lblDesignedByZixu.setForeground(Color.WHITE);
		lblDesignedByZixu.setBounds(127, 613, 229, 16);
		lblDesignedByZixu.setFont(little);
		getContentPane().add(lblDesignedByZixu);
		lblAllRightsReserved.setForeground(Color.WHITE);
		lblAllRightsReserved.setBounds(132, 641, 148, 16);
		lblAllRightsReserved.setFont(little);

		getContentPane().add(lblAllRightsReserved);
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setBounds(158, 585, 92, 16);
		lblCopyright.setFont(little);

		getContentPane().add(lblCopyright);
		this.setLocation(500, 20);
		this.setVisible(true);

	}

	public void mouseExited(MouseEvent e) // 添加鼠标事件，让界面更友好
	{
		if (e.getSource() == jlb_grab)
			jlb_grab.setForeground(Color.WHITE);
		if (e.getSource() == jlb_ping)
			jlb_ping.setForeground(Color.WHITE);
		if (e.getSource() == jlb_traceroute)
			jlb_traceroute.setForeground(Color.WHITE);
		if (e.getSource() == jlb_hack)
			jlb_hack.setForeground(Color.WHITE);

	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == jlb_grab)
			jlb_grab.setForeground(Color.PINK);
		if (e.getSource() == jlb_ping)
			jlb_ping.setForeground(Color.PINK);
		if (e.getSource() == jlb_traceroute)
			jlb_traceroute.setForeground(Color.PINK);
		if (e.getSource() == jlb_hack)
			jlb_hack.setForeground(Color.PINK);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == jlb_grab) {
			this.dispose();
			new GrabbingPacketsMainFrame();


		}
		if (e.getSource() == jlb_ping) {

			this.dispose();
			new StartPingFrame();


		}

		if (e.getSource() == jlb_traceroute) {

			this.dispose();
			new StartTraceRouteFrame();


		}
		if (e.getSource() == jlb_hack) {
			
			
			this.dispose();

			new StartARPAttackFrame();

		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public static void main(String[] args) {
		try
	    {
			UIManager.put("RootPane.setupButtonVisible", false);
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		new MainFrame();
	}
}
