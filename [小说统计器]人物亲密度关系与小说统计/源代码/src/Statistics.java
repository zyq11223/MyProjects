import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

public class Statistics extends JFrame implements MouseListener,Runnable{
	
	JPanel jpl = new JPanel();
	ImageIcon background = new ImageIcon("img3.jpg");
	JLabel jlb1 = new JLabel(background);
	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)screensize.getWidth();
	int h = (int)screensize.getHeight();
	JLabel jlb2 = new JLabel("人物出现频率统计");
	JLabel jlb3 = new JLabel("人物篇幅跨度统计");
	JLabel jlb4 = new JLabel("人物亲密关系统计");
	
	int  vcc=0;
	Frequence_frame ff = new Frequence_frame();
	Close_frame cf =new Close_frame();
	Page_frame pf = new Page_frame();
	
	
	public void run() {
		
		
		
		
		
		try{Thread.sleep(300);}catch (Exception e) {}
		
		jpl.add(jlb2);
		Font jlb2_ = new Font("宋体", Font.BOLD, 30);
		jlb2.setFont(jlb2_);
		jlb2.setForeground(Color.WHITE);
		jlb2.setSize(500, 100);
		jlb2.setLocation(80, 200);
		
		
		
		try{Thread.sleep(300);}catch (Exception e) {}
		jpl.add(jlb3);
		Font jlb3_ = new Font("宋体", Font.BOLD, 30);
		jlb3.setForeground(Color.WHITE);
		jlb3.setFont(jlb3_);
		jlb3.setSize(500, 100);
		jlb3.setLocation(120,300);
		
		
		
		try{Thread.sleep(300);}catch (Exception e) {}
		jpl.add(jlb4);
		Font jlb4_ = new Font("宋体", Font.BOLD, 30);
		jlb4.setForeground(Color.WHITE);
		jlb4.setFont(jlb4_);
		jlb4.setSize(500, 100);
		jlb4.setLocation(160, 400);
		
		
		
		
	}
	
	public Statistics() {
		new Thread(){
			
			public void run() {
				try{cf.additeams();}catch (Exception e) {}
			}
		}.start();
		
	new Thread(){
			
			public void run() {
				try{pf.additeams();}catch (Exception e) {}
			}
		}.start();
new Thread(){
			
			public void run() {
				try{ff.additeams();}catch (Exception e) {}
			}
		}.start();
		
		
		this.setResizable(false); //大小不可改变
		jlb2.addMouseListener(this);
		jlb3.addMouseListener(this);
		jlb4.addMouseListener(this);
		//设置边界大小
		jlb1.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		jpl = (JPanel)this.getContentPane();
		jpl.setOpaque(false);
		
		
		
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(jlb1, new Integer(Integer.MIN_VALUE));
		
		//适应图片大小
		this.setSize(background.getIconWidth(), background.getIconHeight());		
		this.setVisible(false);
		
		jpl.setLayout(null);
		JLabel main_tittle = new JLabel("统     计");
		Font main_font = new Font("宋体", Font.BOLD|Font.ITALIC, 50);
		main_tittle.setFont(main_font);
		jpl.add(main_tittle);
		
		main_tittle.setForeground(Color.WHITE);
		main_tittle.setSize(500, 50);
		main_tittle.setLocation(20, 20);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
	
		
		
		
		
		
		
	}
	
	
	

	public void mouseExited(MouseEvent e) 
	{		
		if(e.getSource()==jlb2)jlb2.setForeground(Color.WHITE);
		if(e.getSource()==jlb3)jlb3.setForeground(Color.WHITE);
		if(e.getSource()==jlb4)jlb4.setForeground(Color.WHITE);
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jlb2){jlb2.setForeground(Color.PINK);}
		if(e.getSource()==jlb3){jlb3.setForeground(Color.PINK);}
		if(e.getSource()==jlb4){jlb4.setForeground(Color.PINK);}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jlb2)ff.setVisible(true);
		if(e.getSource()==jlb3)pf.setVisible(true);
		if(e.getSource()==jlb4)cf.setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	
	
 
	
	
	
}
