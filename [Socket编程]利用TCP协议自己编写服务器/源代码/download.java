import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class download extends JFrame implements ActionListener,FocusListener{

	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	JLabel j_download = new JLabel("服务器上可供下载的文件：");
	JTextArea jtf_download = new JTextArea();
	JTextField jtf_input = new JTextField("请输入你要下载的文件全名：");
	JButton jbt_download = new JButton("下载");
	JScrollPane jsp_download = new JScrollPane(jtf_download);
	
	
	public void download_frame(String download) {
		this.setTitle("下    载");
		this.add(jpl1,BorderLayout.CENTER);
		this.add(jpl2,BorderLayout.SOUTH);
		jpl1.setLayout(new BorderLayout());
		jpl2.setLayout(new BorderLayout());
		jpl1.add(j_download,BorderLayout.NORTH);		
		jpl1.add(jsp_download,BorderLayout.CENTER);
		jpl2.add(jtf_input,BorderLayout.CENTER);
		jpl2.add(jbt_download,BorderLayout.EAST);
		jtf_download.append(download);
		jtf_input.addFocusListener(this);
		jbt_download.addActionListener(this);
		this.setSize(320,500);	
		this.setVisible(false);
	
	     }

	@Override
	public void focusGained(FocusEvent e) {
		jtf_input.setText("");
	}
	@Override
	public void focusLost(FocusEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		//获得输入的文件名并开始下载
		String file_name = jtf_input.getText();
		try{ int flag = new Client().get(file_name);
		Thread.sleep(300);
		if(flag==0)new JOptionPane().showMessageDialog(this, "文件获取失败！"+'\n'+"请检查文件名是正确！");
		}catch (Exception ex) {}
	}
	
}
