import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListAll extends JFrame{
	//界面有关参数
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	JLabel j_download = new JLabel("服务器上可供下载的文件：");
	JLabel j_upload      = new JLabel("用户上传到服务器的文件：");
	JTextArea jtf_download = new JTextArea();
	JTextArea jtf_upload = new JTextArea();
	JScrollPane jsp_download = new JScrollPane(jtf_download);
	JScrollPane jsp_upload = new JScrollPane(jtf_upload);
	
	public void ListAll_frame(String download,String upload) {
		this.setTitle("服务器文件列表");
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jpl2,BorderLayout.CENTER);
		jpl1.setLayout(new BorderLayout());
		jpl2.setLayout(new BorderLayout());
		jpl1.add(j_download,BorderLayout.NORTH);
		jpl2.add(j_upload,BorderLayout.NORTH);
		jpl1.add(jsp_download,BorderLayout.CENTER);
		jpl2.add(jsp_upload,BorderLayout.CENTER);
		jtf_download.append(download);
		jtf_upload.append(upload);
		
		this.setSize(300,700);
		
		
		this.setVisible(false);
	}
	
	
	
	
	
	
}
