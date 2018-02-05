package GrabbingPacketsFrame;
import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import HandleJpcap.AllPackages;
import MainFrame.MainFrame;
import Util.JDBC;
import Util.Statistic;

import java.awt.*;
import java.awt.event.*;

public class GrabbingPacketsMainFrame extends JFrame implements MouseListener{

	// 界面有关变量
		JPanel jpl = new JPanel();
		ImageIcon background = new ImageIcon("backgroundImage.jpg");
		JLabel backgroundImage = new JLabel(background);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screensize.getWidth();
		int h = (int) screensize.getHeight();
		JLabel jlb_start = new JLabel("数据包抓取");
		JLabel jlb_statistic = new JLabel("数据包统计");
		JLabel jlb_remove = new JLabel("数据包重置");
		JLabel jlb_back = new JLabel("返回主界面");
		private final JLabel lblAllRightsReserved = new JLabel("All Rights Reserved");
		private final JLabel lblCopyright = new JLabel("Copyright ©");
		JLabel lblDesignedByZixu = new JLabel("Designed by Zixu Wang");
		
		



		public GrabbingPacketsMainFrame() {

			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false); // 大小不可改变
			jlb_start.addMouseListener(this);
			jlb_statistic.addMouseListener(this);
			jlb_remove.addMouseListener(this);
			jlb_back.addMouseListener(this);

			// 设置边界大小
			backgroundImage.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			jpl = (JPanel) this.getContentPane();
			jpl.setOpaque(false);

			this.getLayeredPane().setLayout(null);
			this.getLayeredPane().add(backgroundImage, new Integer(Integer.MIN_VALUE));

			// 适应图片大小
			this.setSize(background.getIconWidth(), background.getIconHeight());


			jpl.setLayout(null);
			JLabel main_tittle = new JLabel("Network Analyser");
			// 改变字体，下同
			Font main_font = new Font("consolas", Font.BOLD | Font.ITALIC, 38);
			main_tittle.setFont(main_font);
			jpl.add(main_tittle);

			main_tittle.setForeground(Color.WHITE);
			main_tittle.setSize(359, 54);
			main_tittle.setLocation(35, 88);

		
			jpl.add(jlb_start);
			Font jlb_start_ = new Font("consolas", Font.BOLD, 40);
			jlb_start.setFont(jlb_start_);
			jlb_start.setForeground(Color.WHITE);
			jlb_start.setSize(221, 60);
			jlb_start.setLocation(98, 209);

			jpl.add(jlb_statistic);
			Font jlb_statistic_ = new Font("consolas", Font.BOLD, 40);
			jlb_statistic.setForeground(Color.WHITE);
			jlb_statistic.setFont(jlb_statistic_);
			jlb_statistic.setSize(221, 54);
			jlb_statistic.setLocation(98, 307);

	
			jpl.add(jlb_remove);
			Font jlb_remove_ = new Font("consolas", Font.BOLD, 40);
			jlb_remove.setForeground(Color.WHITE);
			jlb_remove.setFont(jlb_remove_);
			jlb_remove.setSize(221, 60);
			jlb_remove.setLocation(98, 395);

	
			jpl.add(jlb_back);
			Font jlb_back_ = new Font("consolas", Font.BOLD, 40);
			jlb_back.setForeground(Color.WHITE);
			jlb_back.setFont(jlb_back_);
			jlb_back.setSize(221, 60);
			jlb_back.setLocation(98, 488);
			
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
			if (e.getSource() == jlb_start)
				jlb_start.setForeground(Color.WHITE);
			if (e.getSource() == jlb_statistic)
				jlb_statistic.setForeground(Color.WHITE);
			if (e.getSource() == jlb_remove)
				jlb_remove.setForeground(Color.WHITE);
			if (e.getSource() == jlb_back)
				jlb_back.setForeground(Color.WHITE);

		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == jlb_start)
				jlb_start.setForeground(Color.PINK);
			if (e.getSource() == jlb_statistic)
				jlb_statistic.setForeground(Color.PINK);
			if (e.getSource() == jlb_remove)
				jlb_remove.setForeground(Color.PINK);
			if (e.getSource() == jlb_back)
				jlb_back.setForeground(Color.PINK);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == jlb_start) {
				this.dispose();
	
				new StartGrabbingFrame();


			}
			if (e.getSource() == jlb_statistic) {
				
				new StatisticFrame();
				this.dispose();

				
			}

			if (e.getSource() == jlb_remove) {
				

				AllPackages.RemoveAll();
				Statistic.ClearAll();
				JOptionPane.showMessageDialog(this, "缓存已被清除");

					
				
				
			}
			if (e.getSource() == jlb_back) {
				
				this.dispose();
				new MainFrame();
			
			
				}
			}

		
	

		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根

		}


		public static void main(String[] args) {
			
			new GrabbingPacketsMainFrame();
		}



}
