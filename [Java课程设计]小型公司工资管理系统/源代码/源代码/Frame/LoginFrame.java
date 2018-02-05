package Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import Util.JDBC;

public class LoginFrame extends JFrame implements ActionListener{
	private JTextField AccField;
	private JPasswordField PwdField;
	JButton Login = new JButton("Login");

	JPanel jpl = new JPanel();
	JLabel Acc = new JLabel("Account:");
	JLabel Pwd = new JLabel("Password:");
	Font font = new Font("consolas", Font.BOLD | Font.ITALIC, 25);
	ImageIcon background = new ImageIcon("LoginImage.jpg");
	JLabel backgroundImage = new JLabel(background);
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) screensize.getWidth();
	int h = (int) screensize.getHeight();

	public LoginFrame() {

		this.setResizable(false); // 大小不可改变
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
		this.setLocation(435, 180);

		jpl.setLayout(null);

		Acc.setForeground(Color.WHITE);
		Acc.setBounds(92, 62, 134, 29);
		Acc.setFont(font);
		jpl.add(Acc);

		Pwd.setForeground(Color.WHITE);
		Pwd.setBounds(75, 123, 134, 29);
		Pwd.setFont(font);
		jpl.add(Pwd);

		AccField = new JTextField();
		AccField.setBounds(231, 61, 189, 29);
		jpl.add(AccField);
		AccField.setColumns(10);

		PwdField = new JPasswordField();
		PwdField.setBounds(231, 122, 189, 29);
		jpl.add(PwdField);
		Login.setVerticalAlignment(SwingConstants.BOTTOM);

		Login.setBounds(200, 193, 134, 43);
		Login.setFont(font);
		jpl.add(Login);
		Login.setForeground(Color.gray);
		Login.addActionListener(this);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(AccField.getText().length()<=0) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;
		}
		
		
		if(PwdField.getPassword().length<=0) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
			
		
		
		
		int flag = JDBC.LoginCharge(AccField.getText(),new String(PwdField.getPassword()));
		switch (flag) {
case 1:
			JOptionPane.showMessageDialog(this, "账号不存在");
			return;
case 2:
	JOptionPane.showMessageDialog(this, "密码不正确");
	return;

case 3:
	JOptionPane.showMessageDialog(this, "数据库连接失败");
	return;
case 0:
	new MainFrame();
	this.dispose();
	break;

		default:
			break;
		}
		
		
	}

	public static void main(String[] args) {
		try
	    {
			UIManager.put("RootPane.setupButtonVisible", false);
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		new LoginFrame();
	}
}
