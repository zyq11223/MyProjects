package GrabbingPacketsFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import HandleJpcap.Packages;

public class DetailIPPackages extends JFrame{

	
	
	public DetailIPPackages(Packages p) {
		

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
	

		
		jta.append('\n'+"版本："+p.version+'\n');
		jta.append("协议："+p.protocol+"协议"+'\n');
		jta.append("数据包标识："+p.ident+'\n');
		jta.append("生存时间："+p.TTL+'\n');
		jta.append("头长度："+p.header_length+'\n');
		jta.append("数据包总长度："+p.total_length+'\n');
		jta.append("优先权："+p.priority+'\n');
		jta.append("服务类型："+p.rsv_tos+'\n');
		jta.append("区分服务--最大的吞吐量："+p.TF+'\n');
		jta.append("区分服务--最高的可靠性："+p.RF+'\n');
		jta.append("是否分段："+p.DF+'\n');
		if(p.DF.equals("true"))
		{

			jta.append("是否分段：不允许分段"+'\n');
		}else {
			jta.append("是否分段：允许分段"+'\n');
		}
		jta.append("More Fragment："+p.MF+'\n');
		


		jta.append("分段偏移量："+p.offset+'\n');

		jta.append("源IP地址："+p.srcIP+'\n');
		jta.append("目的IP地址："+p.dstIP+'\n');
		jta.append("源主机名："+p.srcHost+'\n');
		jta.append("目的主机名："+p.dstHost+'\n');
		jta.append("源MAC地址："+p.srcMAC+'\n');
		jta.append("目的MAC地址："+p.dstMAC+'\n');
		jta.append("源端口号："+p.srcPort+'\n');
		jta.append("目的端口号："+p.dstPort+'\n');
		jta.append("ICMP 报文代码："+p.ICMP_code+'\n');
		jta.append("ICMP 报文类型："+p.ICMP_type+'\n');
		jta.append("校验和："+p.checksum+'\n');
		jta.append("包内容："+p.info+'\n');
		

		jta.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		jta.setForeground(Color.BLACK);







		this.setResizable(false);

		this.add(jsp);
		this.setLocation(945,100);
		this.setSize(300,500);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		Packages p = new Packages("", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""); 

		new DetailIPPackages(p);
	}
	
	
}
