import javax.print.attribute.standard.PrinterLocation;
import javax.security.auth.Subject;
import javax.swing.*;
import javax.xml.stream.events.StartDocument;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Wash extends JFrame implements ActionListener{
	
	int sum;
	int sum0;
	JLabel[] jlb = new JLabel[52];

	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	
	JButton jbt1 = new JButton("next");
	JButton jbt2 = new JButton("last");
	JButton jbt3 = new JButton("Final");
	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)screensize.getWidth();
	int h = (int)screensize.getHeight();
	
	
	int i=0;
	int[] t1 = new int[52] ;
	int[][] t2 = new int[52][52] ;
	
	
	int countcharge(int sum)
	{
		
		
		int[] arry = new int[sum];
		int[] arry2 = new int[sum];
		int[] arry3 = new int[sum];
		for(int i=0;i<sum;i++)
		arry[i]=i+1;//初始化
		
		
		
		for(int i=1;i<=sum;i++)
			{
			int	t0=(2*i)%(sum+1);
			    arry2[t0-1] = arry[i-1];
			}
		
			
		int count = 1;//洗牌次数
		
		for(int i=0;i<sum;i++)
		{
			
		    arry3[i] = arry2[i];
		}		
		
		
		while(true){
			
			
			
			
			
			boolean charge=true;//判断是否还原
			for(int i=0;i<sum;i++)
			{
				if(arry2[i]!=arry[i])charge = false;
					
			}
			
			if(charge == true)break;
			
			
			
			
			
			
			
			
			
			
			for(int i=1;i<=sum;i++)
			{
				int t=(2*i)%(sum+1);
			    arry2[t-1] = arry3[i-1];
			}
		
		for(int i=0;i<sum;i++)
		{
			
		    arry3[i] = arry2[i];
		}
			
			count++;
			
			
			
			
			
			}
			
			
		
		
		
		
		
		
		
		
		return count;
	}
	
	public  Wash(){

						this.add(jpl1,BorderLayout.CENTER);
						this.add(jpl2,BorderLayout.SOUTH);
jpl1.setLayout(null);
						jbt1.addActionListener(this);
						jbt2.addActionListener(this);
						jbt3.addActionListener(this);
						
						jpl2.add(jbt1);
						jpl2.add(jbt2);
						jpl2.add(jbt3);
						
						
						
						
						jlb[0] = new JLabel(new ImageIcon("3.jpg"));	
						jlb[1] = new JLabel(new ImageIcon("4.jpg"));	
						jlb[2] = new JLabel(new ImageIcon("5.jpg"));	
						jlb[3] = new JLabel(new ImageIcon("6.jpg"));	
						jlb[4] = new JLabel(new ImageIcon("7.jpg"));	
						jlb[5] = new JLabel(new ImageIcon("8.jpg"));	
						jlb[6] = new JLabel(new ImageIcon("9.jpg"));	
						jlb[7] = new JLabel(new ImageIcon("10.jpg"));	
						jlb[8] = new JLabel(new ImageIcon("11.jpg"));	
						jlb[9] = new JLabel(new ImageIcon("12.jpg"));	
						jlb[10] = new JLabel(new ImageIcon("13.jpg"));	
						jlb[11] = new JLabel(new ImageIcon("14.jpg"));	
						jlb[12] = new JLabel(new ImageIcon("15.jpg"));	
						jlb[13] = new JLabel(new ImageIcon("16.jpg"));	
						jlb[14] = new JLabel(new ImageIcon("17.jpg"));	
						jlb[15] = new JLabel(new ImageIcon("18.jpg"));	
						jlb[16] = new JLabel(new ImageIcon("19.jpg"));	
						jlb[17] = new JLabel(new ImageIcon("20.jpg"));	
						jlb[18] = new JLabel(new ImageIcon("21.jpg"));	
						
						jlb[19] = new JLabel(new ImageIcon("22.jpg"));
						jlb[20] = new JLabel(new ImageIcon("23.jpg"));	
						jlb[21] = new JLabel(new ImageIcon("24.jpg"));	
						jlb[22] = new JLabel(new ImageIcon("25.jpg"));	
						jlb[23] = new JLabel(new ImageIcon("26.jpg"));	
						jlb[24] = new JLabel(new ImageIcon("27.jpg"));	
						jlb[25] = new JLabel(new ImageIcon("28.jpg"));
						jlb[26] = new JLabel(new ImageIcon("29.jpg"));
						jlb[27] = new JLabel(new ImageIcon("30.jpg"));	
						jlb[28] = new JLabel(new ImageIcon("31.jpg"));	
						
						jlb[29] = new JLabel(new ImageIcon("32.jpg"));
						jlb[30] = new JLabel(new ImageIcon("33.jpg"));	
						jlb[31] = new JLabel(new ImageIcon("34.jpg"));	
						jlb[32] = new JLabel(new ImageIcon("35.jpg"));	
						jlb[33] = new JLabel(new ImageIcon("36.jpg"));	
						jlb[34] = new JLabel(new ImageIcon("37.jpg"));	
						jlb[35] = new JLabel(new ImageIcon("38.jpg"));
						jlb[36] = new JLabel(new ImageIcon("39.jpg"));
						jlb[37] = new JLabel(new ImageIcon("40.jpg"));	
						jlb[38] = new JLabel(new ImageIcon("41.jpg"));	
						
						jlb[39] = new JLabel(new ImageIcon("42.jpg"));
						jlb[40] = new JLabel(new ImageIcon("43.jpg"));	
						jlb[41] = new JLabel(new ImageIcon("44.jpg"));	
						jlb[42] = new JLabel(new ImageIcon("45.jpg"));	
						jlb[43] = new JLabel(new ImageIcon("46.jpg"));	
						jlb[44] = new JLabel(new ImageIcon("47.jpg"));	
						jlb[45] = new JLabel(new ImageIcon("48.jpg"));
						jlb[46] = new JLabel(new ImageIcon("49.jpg"));
						jlb[47] = new JLabel(new ImageIcon("50.jpg"));	
						jlb[48] = new JLabel(new ImageIcon("51.jpg"));	
						
						jlb[49] = new JLabel(new ImageIcon("52.jpg"));
						jlb[50] = new JLabel(new ImageIcon("53.jpg"));
						jlb[51] = new JLabel(new ImageIcon("54.jpg"));	

						
							
					
						String str=JOptionPane.showInputDialog("请输入你要洗牌的张数(偶数张,且2<=n<=52)");
						
						sum = Integer.parseInt(str);
					  sum0 = countcharge(sum);
						
						
						
						if(sum%2!=0||sum<2||sum>52)
							System.exit(1);
						
						
						
						this.setSize(w, 300);
						

						this.setVisible(true);
						this.setDefaultCloseOperation(EXIT_ON_CLOSE);
						
					
					
						int space = w/(sum+1);
						
					
						for(int i=0;i<sum;i++)
							{t1[i]=i+1;
							t2[0][i]=i+1;
							}
						
					
						
						for(int i=0;i<sum;i++)//展示原始扑克
						{
							int x=space*(i+1);
							jpl1.add(jlb[i]);			
							jlb[i].setSize(100, 200);
						jlb[i].setLocation(x, 10);
							
						}
						
					
					
						
						
						
						
						
							
							
							
							

							
						
						
						 
						
						
						}
						
						
	
						
					
	
	
	
	
	
	public void	actionPerformed(ActionEvent e){
		
	int	space = w/(sum+1);
		
	
		
		if(e.getSource()==jbt1)
		{
			
			
			this.setTitle("第"+(++i)+"次洗牌");
			
			for(int k=1;k<=sum;k++)
				{
				t1[k-1]=(2*t1[k-1])%(sum+1);
				t2[i][k-1] = t1[k-1];
				}
			    
			for(int j=0;j<sum;j++)
			{
				int x=space*(t1[j]-1);
			
				jlb[j].setLocation(x, 10);
			}
		
		}
			
		else if(e.getSource()==jbt2)
		{
			if(i-1<0)JOptionPane.showMessageDialog(this,"已经是最初状态！");
			else{
this.setTitle("第"+(--i)+"次洗牌");
			

			for(int k=1;k<=sum;k++){
				t1[k-1]=t2[i][k-1];
			}
				
			    
			for(int j=0;j<sum;j++)
			{
				int x=space*(t1[j]-1);
			
				jlb[j].setLocation(x, 10);
			}
			}
		}
		else if(e.getSource()==jbt3)
		{
			this.setTitle("第"+sum0+"次洗牌");
			i=sum0;
			for(int i=0;i<sum;i++)//展示原始扑克
			{
				int x=space*(i+1);
				jpl1.add(jlb[i]);			
				jlb[i].setSize(100, 200);
			jlb[i].setLocation(x, 10);
				
			}
			 try{	Thread.sleep(1500);}catch (Exception ex) {	}
				JOptionPane.showMessageDialog(this,"一次洗牌还原总共洗了"+sum0+"次！");
		
				try{	Thread.sleep(1000);}catch (Exception ex) {	}
				System.exit(1);
		}
			
	
	}
	
	
	

	
	public static void main(String[] args) {
		new Wash();
		
	}
	
	
}
