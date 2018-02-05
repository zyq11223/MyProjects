package GrabbingPacketsFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import HandleJpcap.Packages;

public class DetailARPPackages extends JFrame {

	public DetailARPPackages(Packages p) {

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);

		jta.append('\n' + "版本：" + p.version + '\n');
		jta.append("协议：" + p.protocol + "协议" + '\n');
		jta.append("头长度：" + p.header_length + '\n');
		jta.append("数据包总长度：" + p.total_length + '\n');
		jta.append("硬件类型：" + p.TF + '\n');
		jta.append("协议类型：" + p.RF + '\n');
		jta.append("硬件地址长度：" + p.DF + '\n');
		jta.append("协议地址长度：" + p.MF + '\n');
		jta.append("操作字段：" + p.rsv_tos + '\n');

		jta.append("源IP地址：" + p.srcIP + '\n');
		jta.append("目的IP地址：" + p.dstIP + '\n');
		jta.append("源MAC地址：" + p.srcMAC + '\n');
		jta.append("目的MAC地址：" + p.dstMAC + '\n');
		jta.append("包内容：" + p.info + '\n');

		jta.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));

		this.setResizable(false);
		this.add(jsp);
		this.setLocation(945, 100);
		this.setSize(300, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Packages p = new Packages("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "");

		new DetailARPPackages(p);
	}

}
