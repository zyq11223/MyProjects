import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends JFrame implements MouseListener{
	//界面有关变量
	JPanel jpl = new JPanel();
	ImageIcon background = new ImageIcon("img3.jpg");
	JLabel jlb1 = new JLabel(background);
	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)screensize.getWidth();
	int h = (int)screensize.getHeight();
	JLabel jlb2 = new JLabel("上传文件");
	JLabel jlb3 = new JLabel("查看列表");
	JLabel jlb4 = new JLabel("下载文件");
	int  vcc=0;

	//与文件列表显示有关的变量
	String download = "";
	String upload = "";
	
	public Frame() {
		
		
		
		
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
		JLabel main_tittle = new JLabel("客    户    端");
		//改变字体，下同
		Font main_font = new Font("宋体", Font.BOLD|Font.ITALIC, 50);
		main_tittle.setFont(main_font);
		jpl.add(main_tittle);
		
		main_tittle.setForeground(Color.WHITE);
		main_tittle.setSize(500, 50);
		main_tittle.setLocation(20, 20);
		
		
		
		
		
			
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
                
				
				
				
				
			}
		
		
		
				
	
		
		
		
		public void get_data(String str1,String str2)
		{//分别保存上传和下载的文件列表
			 download = str1;
			 upload = str2;
			
		}
		

	
	

	public void mouseExited(MouseEvent e) //添加鼠标事件，让界面更友好
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
		if(e.getSource()==jlb2)
		{//上传

			try{new Client().put();}catch (Exception ex) {}
		}
		if(e.getSource()==jlb3) //查看文件列表
		{
			try{
				String str_list = new Client().pre_list();
	//		int index = str_list.indexOf("./uploads/") ;
//			String download = str_list.substring(13,index);
//			String upload = str_list.substring(index+11);
			String download = str_list;
			
			ListAll list=new ListAll();
			list.ListAll_frame(str_list,str_list);
			list.setVisible(true);
			
			}catch (Exception ex) {}
		}
		
		
		if(e.getSource()==jlb4)
		{//下载
			try{String str_list = new Client().pre_list();	
		
		String download = str_list;
			download d= new download();
			d.download_frame(download);			
			d.setVisible(true);
		}catch (Exception ex) {}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	public static void main(String[] args) throws Exception{
		Frame frame = new Frame();//打开主界面

	}
	
}
