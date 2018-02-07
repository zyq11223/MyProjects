package GrabbingPacketsFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import HandleJpcap.Packages;
import Util.JDBC;
import Util.Parameter;

import java.awt.*;
import java.awt.event.*;

public class IPPackageFrame extends JFrame implements ActionListener{
	

	
	// 界面有关变量
		JPanel jpl = new JPanel();
		JPanel jpl1 = new JPanel();
		JPanel jpl2 = new JPanel();
		ImageIcon background = new ImageIcon("Insertbackground.jpg");
		JLabel Insertbackground = new JLabel(background);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screensize.getWidth();
		int h = (int) screensize.getHeight();
		JButton jbt1 = new JButton("详 情");
		JButton jbt2 = new JButton("关 闭");

		


		
		Font jlb_ = new Font("consolas", Font.BOLD, 20);
		
		
		ButtonGroup SexGroup = new ButtonGroup();
		Font buttonFont = new Font("consolas",  Font.BOLD | Font.ITALIC, 15);
		
		Packages packages;



		
		public IPPackageFrame(Packages packages){
			
			this.packages = packages;

			
			
			
			this.setTitle("数据包内容显示");
			this.setResizable(false); // 大小不可改变
			// 设置边界大小
			Insertbackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			jpl= (JPanel) this.getContentPane();
			jpl.setOpaque(false);
			this.getLayeredPane().setLayout(null);
			this.getLayeredPane().add(Insertbackground, new Integer(Integer.MIN_VALUE));
			// 适应图片大小
			this.setSize(443, 854);


			jpl.setLayout(null);

		
			JLabel jlb_version = new JLabel("版本：");
			JTextField jtf_no = new JTextField();
			jpl.add(jlb_version);
			jlb_version.setFont(jlb_);
			jlb_version.setForeground(Color.WHITE);
			jlb_version.setSize(120,30);
			jlb_version.setLocation(39, 124);
			jpl.add(jtf_no);
			jtf_no.setSize(215,30);
			jtf_no.setLocation(185, 122);
			jtf_no.setText(packages.version);
			jtf_no.setForeground(new Color(105,105,105));
			
			JLabel jlb_protocol = new JLabel("协议类型：");
			JTextField jtf_protocol = new JTextField();
			jlb_protocol.setForeground(Color.WHITE);
			jlb_protocol.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_protocol.setBounds(39, 166, 119, 30);
			getContentPane().add(jlb_protocol);
			
			jtf_protocol.setText(packages.protocol+"协议");
			jtf_protocol.setForeground(new Color(105, 105, 105));
			jtf_protocol.setBounds(185, 164, 215, 30);
			getContentPane().add(jtf_protocol);
			
			JLabel jlb_srcIP = new JLabel("源IP地址：");
			JTextField jtf_srcIP = new JTextField();
			jlb_srcIP.setForeground(Color.WHITE);
			jlb_srcIP.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_srcIP.setBounds(39, 208, 119, 30);
			getContentPane().add(jlb_srcIP);
			
			jtf_srcIP.setText(packages.srcIP);
			jtf_srcIP.setForeground(new Color(105, 105, 105));
			jtf_srcIP.setBounds(185, 206, 215, 30);
			getContentPane().add(jtf_srcIP);
			
			JLabel jlb_dstIP = new JLabel("目的IP地址：");
			JTextField jtf_dstIP = new JTextField();
			jlb_dstIP.setForeground(Color.WHITE);
			jlb_dstIP.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_dstIP.setBounds(39, 249, 135, 30);
			getContentPane().add(jlb_dstIP);
			
			jtf_dstIP.setText(packages.dstIP);
			jtf_dstIP.setForeground(new Color(105, 105, 105));
			jtf_dstIP.setBounds(185, 248, 215, 30);
			getContentPane().add(jtf_dstIP);
			
			JLabel jlb_srcMAC = new JLabel("源MAC地址：");
			JTextField jtf_srcMAC = new JTextField();
			jlb_srcMAC.setForeground(Color.WHITE);
			jlb_srcMAC.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_srcMAC.setBounds(39, 290, 135, 30);
			getContentPane().add(jlb_srcMAC);
			
			jtf_srcMAC.setText(packages.srcMAC);
			jtf_srcMAC.setForeground(new Color(105, 105, 105));
			jtf_srcMAC.setBounds(185, 288, 215, 30);
			getContentPane().add(jtf_srcMAC);
			
			JLabel jlb_dstMAC = new JLabel("目的MAC地址：");
			jlb_dstMAC.setForeground(Color.WHITE);
			jlb_dstMAC.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_dstMAC.setBounds(39, 334, 135, 30);
			getContentPane().add(jlb_dstMAC);
			
			JTextField jtf_dstMAC = new JTextField();
			jtf_dstMAC.setText(packages.dstMAC);
			jtf_dstMAC.setForeground(new Color(105, 105, 105));
			jtf_dstMAC.setBounds(185, 330, 215, 30);
			getContentPane().add(jtf_dstMAC);
			
			JLabel jlb_headerlen = new JLabel("头长度：");
			jlb_headerlen.setForeground(Color.WHITE);
			jlb_headerlen.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_headerlen.setBounds(39, 376, 135, 30);
			getContentPane().add(jlb_headerlen);
			
			JTextField jtf_headerlen = new JTextField();
			jtf_headerlen.setText(packages.header_length);
			jtf_headerlen.setForeground(new Color(105, 105, 105));
			jtf_headerlen.setBounds(185, 372, 215, 30);
			getContentPane().add(jtf_headerlen);
			
			
			JLabel jlb_len = new JLabel("数据包长度：");
			jlb_len.setForeground(Color.WHITE);
			jlb_len.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_len.setBounds(39, 418, 135, 30);
			getContentPane().add(jlb_len);
			
			JTextField jtf_len = new JTextField();
			jtf_len.setText(packages.total_length);
			jtf_len.setForeground(new Color(105, 105, 105));
			jtf_len.setBounds(185, 414, 215, 30);
			getContentPane().add(jtf_len);
			
			JLabel jlb_TTL = new JLabel("生存时间：");
			jlb_TTL.setForeground(Color.WHITE);
			jlb_TTL.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_TTL.setBounds(39, 460, 135, 30);
			getContentPane().add(jlb_TTL);
			
			JTextField jtf_TTL = new JTextField();		
			jtf_TTL.setText(packages.TTL);
			jtf_TTL.setForeground(new Color(105, 105, 105));
			jtf_TTL.setBounds(185, 456, 215, 30);
			getContentPane().add(jtf_TTL);
			
			JLabel jlb_serve = new JLabel("服务类型：");
			jlb_serve.setForeground(Color.WHITE);
			jlb_serve.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_serve.setBounds(39, 502, 135, 30);
			getContentPane().add(jlb_serve);
			
			JTextField jtf_serve = new JTextField();	
			jtf_serve.setText(packages.rsv_tos);
			jtf_serve.setForeground(new Color(105, 105, 105));
			jtf_serve.setBounds(185, 498, 215, 30);
			getContentPane().add(jtf_serve);
			
			JLabel jlb_ident = new JLabel("数据包标识：");
			jlb_ident.setForeground(Color.WHITE);
			jlb_ident.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_ident.setBounds(39, 544, 135, 30);
			getContentPane().add(jlb_ident);
			
			JTextField jtf_ident = new JTextField();	
			jtf_ident.setText(packages.ident);
			jtf_ident.setForeground(new Color(105, 105, 105));
			jtf_ident.setBounds(185, 540, 215, 30);
			getContentPane().add(jtf_ident);
			
			JLabel jlb_fragment = new JLabel("是否分段：");
			jlb_fragment.setForeground(Color.WHITE);
			jlb_fragment.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_fragment.setBounds(39, 586, 135, 30);
			getContentPane().add(jlb_fragment);
			
			JTextField jtf_fragment = new JTextField();
				if(packages.DF.equals("true"))
				{
					jtf_fragment.setText("不允许分段");
				}else {
					jtf_fragment.setText("允许分段");
				}
			
			jtf_fragment.setForeground(new Color(105, 105, 105));
			jtf_fragment.setBounds(185, 582, 215, 30);
			getContentPane().add(jtf_fragment);
			
			JLabel jlb_offset = new JLabel("分段偏移量：");
			jlb_offset.setForeground(Color.WHITE);
			jlb_offset.setFont(new Font("Consolas", Font.BOLD, 20));
			jlb_offset.setBounds(39, 628, 135, 30);
			getContentPane().add(jlb_offset);
			
			JTextField jtf_offset = new JTextField();
			jtf_offset.setText(packages.offset);
			jtf_offset.setForeground(new Color(105, 105, 105));
			jtf_offset.setBounds(185, 624, 215, 30);
			getContentPane().add(jtf_offset);
			

			

			

			

			


			

			

			

			

			jbt1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
			jbt1.setBounds(68, 697, 130, 46);
			getContentPane().add(jbt1);
			jbt1.addActionListener(this);


			jbt2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
			jbt2.setBounds(247, 697, 130, 46);
			getContentPane().add(jbt2);
			jbt2.addActionListener(this);
			
			this.setLocation(500, 20);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbt1)
			{
				new DetailIPPackages(packages);
			}
			
			if(e.getSource()==jbt2)
			{
				this.dispose();
			}
			
		}
		
		public static void main(String[] args) {
			Packages p = new Packages("", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""); 

			new IPPackageFrame(p);
		}
		
}
