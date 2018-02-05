import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main_Frame extends JFrame implements MouseListener{
	JPanel jpl = new JPanel();
	ImageIcon background = new ImageIcon("img3.jpg");
	JLabel jlb1 = new JLabel(background);
	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)screensize.getWidth();
	int h = (int)screensize.getHeight();
	JLabel jlb2 = new JLabel("小说简介");
	JLabel jlb3 = new JLabel("阅读小说");
	JLabel jlb4 = new JLabel("人物统计");
	JProgressBar jpb = new JProgressBar(0,100);
	int  vcc=0;
	Statistics statistics ;
	Introduce i = new Introduce();
	Read r = new Read();
	
	public Main_Frame() {
		new Thread(){
			
			public void run() {
				try{statistics = new Statistics();}catch (Exception e) {}
			}
		}.start();
		

				try{
					r.show_read(this);
					i.show_introduce(this);
				}catch (Exception e) {}
			
		
		
		
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		jpl.setLayout(null);
		JLabel main_tittle = new JLabel("地球往事－黑暗森林");
		Font main_font = new Font("宋体", Font.BOLD|Font.ITALIC, 50);
		main_tittle.setFont(main_font);
		jpl.add(main_tittle);
		
		main_tittle.setForeground(Color.WHITE);
		main_tittle.setSize(500, 50);
		main_tittle.setLocation(20, 20);
		
		
		
		
		jpb.setLocation(10, 500);
		jpb.setSize(500, 30);
		jpb.setStringPainted(true);
		jpb.setBackground(Color.GREEN);
		
		
		
		
		
		
		new Thread(){
			public void run()
			{  
				jpl.add(jpb);
				for(int i=0;i<101;i++)
				{
					try{Thread.sleep(100);}catch (Exception e) {}
					jpb.setValue(i);
				
				}
				
				   jpl.remove(jpb);
				
				
				
				try{Thread.sleep(300);}catch (Exception e) {}
				
				jpl.add(jlb2);
				Font jlb2_ = new Font("宋体", Font.BOLD, 50);
				jlb2.setFont(jlb2_);
				jlb2.setForeground(Color.WHITE);
				jlb2.setSize(500, 100);
				jlb2.setLocation(80, 200);
				
				
				
				try{Thread.sleep(300);}catch (Exception e) {}
				jpl.add(jlb3);
				Font jlb3_ = new Font("宋体", Font.BOLD, 50);
				jlb3.setForeground(Color.WHITE);
				jlb3.setFont(jlb3_);
				jlb3.setSize(500, 100);
				jlb3.setLocation(120,300);
				
				
				
				try{Thread.sleep(300);}catch (Exception e) {}
				jpl.add(jlb4);
				Font jlb4_ = new Font("宋体", Font.BOLD, 50);
				jlb4.setForeground(Color.WHITE);
				jlb4.setFont(jlb4_);
				jlb4.setSize(500, 100);
				jlb4.setLocation(160, 400);
				
				
				jpl.remove(jpb);
				
			}
		}.start();
		
		
				
	
		
		
		
		
		
		
	}
	
	
	

	public void mouseExited(MouseEvent e) 
	{		
		if(e.getSource()==jlb2)jlb2.setForeground(Color.WHITE);
		if(e.getSource()==jlb3)jlb3.setForeground(Color.WHITE);
		if(e.getSource()==jlb4)jlb4.setForeground(Color.WHITE);
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jlb2)jlb2.setForeground(Color.PINK);
		if(e.getSource()==jlb3)jlb3.setForeground(Color.PINK);
		if(e.getSource()==jlb4)jlb4.setForeground(Color.PINK);
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jlb2)i.jd1.setVisible(true); 
		if(e.getSource()==jlb3)r.jd1.setVisible(true);
		if(e.getSource()==jlb4){statistics.setVisible(true);new Thread(statistics).start();}
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	
}

