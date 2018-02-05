package Frame;
import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import Util.JDBC;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements MouseListener{

	// 界面有关变量
		JPanel jpl = new JPanel();
		ImageIcon background = new ImageIcon("backgroundImage.jpg");
		JLabel backgroundImage = new JLabel(background);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screensize.getWidth();
		int h = (int) screensize.getHeight();
		JLabel jlb_insert = new JLabel("添加记录");
		JLabel jlb_search = new JLabel("查询记录");
		JLabel jlb_display = new JLabel("显示信息");
		JLabel jlb_statistic = new JLabel("统计整理");
		private final JLabel lblAllRightsReserved = new JLabel("All Rights Reserved");
		private final JLabel lblCopyright = new JLabel("Copyright ©");
		JLabel lblDesignedByZixu = new JLabel("Designed by Zixu Wang");



		public MainFrame() {

			this.setResizable(false); // 大小不可改变
			jlb_insert.addMouseListener(this);
			jlb_search.addMouseListener(this);
			jlb_display.addMouseListener(this);
			jlb_statistic.addMouseListener(this);

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
			JLabel main_tittle = new JLabel("B&T  Corporation");
			// 改变字体，下同
			Font main_font = new Font("consolas", Font.BOLD | Font.ITALIC, 35);
			main_tittle.setFont(main_font);
			jpl.add(main_tittle);

			main_tittle.setForeground(Color.WHITE);
			main_tittle.setSize(359, 54);
			main_tittle.setLocation(51, 111);

		
			jpl.add(jlb_insert);
			Font jlb_insert_ = new Font("consolas", Font.BOLD, 40);
			jlb_insert.setFont(jlb_insert_);
			jlb_insert.setForeground(Color.WHITE);
			jlb_insert.setSize(221, 60);
			jlb_insert.setLocation(121, 210);

			jpl.add(jlb_search);
			Font jlb_search_ = new Font("consolas", Font.BOLD, 40);
			jlb_search.setForeground(Color.WHITE);
			jlb_search.setFont(jlb_search_);
			jlb_search.setSize(221, 54);
			jlb_search.setLocation(121, 305);

	
			jpl.add(jlb_display);
			Font jlb_display_ = new Font("consolas", Font.BOLD, 40);
			jlb_display.setForeground(Color.WHITE);
			jlb_display.setFont(jlb_display_);
			jlb_display.setSize(221, 60);
			jlb_display.setLocation(121, 394);

	
			jpl.add(jlb_statistic);
			Font jlb_statistic_ = new Font("consolas", Font.BOLD, 40);
			jlb_statistic.setForeground(Color.WHITE);
			jlb_statistic.setFont(jlb_statistic_);
			jlb_statistic.setSize(221, 60);
			jlb_statistic.setLocation(121, 487);
			
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
			if (e.getSource() == jlb_insert)
				jlb_insert.setForeground(Color.WHITE);
			if (e.getSource() == jlb_search)
				jlb_search.setForeground(Color.WHITE);
			if (e.getSource() == jlb_display)
				jlb_display.setForeground(Color.WHITE);
			if (e.getSource() == jlb_statistic)
				jlb_statistic.setForeground(Color.WHITE);

		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == jlb_insert)
				jlb_insert.setForeground(Color.PINK);
			if (e.getSource() == jlb_search)
				jlb_search.setForeground(Color.PINK);
			if (e.getSource() == jlb_display)
				jlb_display.setForeground(Color.PINK);
			if (e.getSource() == jlb_statistic)
				jlb_statistic.setForeground(Color.PINK);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == jlb_insert) {
				this.dispose();
				new InsertFrame();
			}
			if (e.getSource() == jlb_search) {
				
				this.dispose();
				new QueryFrame();
				
			}

			if (e.getSource() == jlb_display) {
				
				String result = JDBC.searchAll();
				if(result==null||result.equals(null))
				{
					JOptionPane.showMessageDialog(this, "未查询到任何信息！");
					return;
				}else if(result.equals("Fail"))
				{
					JOptionPane.showMessageDialog(this, "查询失败");
					return;
				}else {
					DisplayFrame.createAndShowGUI(result);
					this.dispose();
					
				}
				
			}
			if (e.getSource() == jlb_statistic) {
				new StatisticFrame();
				this.dispose();
			
				}
			}

		
	

		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根

		}


		public static void main(String[] args) {
			
			new MainFrame();
		}
}
