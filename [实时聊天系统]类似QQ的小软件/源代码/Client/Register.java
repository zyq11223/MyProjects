package Client;

import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.awt.*;
import javax.swing.*;

import Util.Customer;
import Util.Message;
import Util.Mtype;

public class Register extends JFrame implements ActionListener,Serializable{

	private JLabel jlbaccount = new JLabel("请输入帐号：");
	private JTextField jtfaccount = new JTextField(10);
	
	private JLabel jlbpwd = new JLabel("请输入密码：");
	private JPasswordField jtfpwd = new JPasswordField(10);
	
	private JLabel jlbpwd2 = new JLabel("请确认密码：");
	private JPasswordField jtfpwd2 = new JPasswordField(10);
	
	private JLabel jlbname = new JLabel("请输入昵称：");
	private JTextField jtfname = new JTextField(10);
	
	JButton jbt1 = new JButton("注册");
	JButton jbt2 = new JButton("登陆");
	
	public Register() {
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(600,300);
		this.setSize(250,200);
		this.add(jlbaccount);
		this.add(jtfaccount);
		this.add(jlbpwd);
		this.add(jtfpwd);
		this.add(jlbpwd2);
		this.add(jtfpwd2);
		this.add(jlbname);
		this.add(jtfname);
		this.add(jbt1);
		this.add(jbt2);
		
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
	}
	
	public void register() {
		
		Customer customer = new Customer();
		customer.setAccount(jtfaccount.getText());
		customer.setPwd(new String(jtfpwd.getPassword()));
		customer.setName(jtfname.getText());
		
		Message message = new Message();
		message.setType(Mtype.REGISTER);
		message.setContent(customer);
		
		try{
			Socket socket = new Socket(Mtype.IP, Mtype.PORT);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(message);
			Message returnMessage = (Message)ois.readObject();
			String type = returnMessage.getType();
			if(type.equals(Mtype.REGISTERFALL))
			{
				JOptionPane.showMessageDialog(this, "注册失败");
			}
			else if(type.equals(Mtype.REGISTERSUCCESS))
			{
				JOptionPane.showMessageDialog(this, "注册成功");
				this.dispose();
				new Login();
			}
			else {
				JOptionPane.showMessageDialog(this, "出现未知错误");
				System.exit(0);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "网络异常");
			System.exit(0);
		}
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbt1)
		{
			String account = jtfaccount.getText();
			String pwd =new String(jtfpwd.getPassword()) ;
			String pwd2 =new String(jtfpwd2.getPassword()) ;
			String name =jtfname.getText();
			
			if(account==null||account.length()<5)
			{
				JOptionPane.showMessageDialog(this, "用户名太短");
				return;
			}
			
			if(account==null||account.length()<6)
			{
				JOptionPane.showMessageDialog(this, "用户名太短");
				return;
			}
			
			if(pwd==null||pwd.length()<6)
			{
				JOptionPane.showMessageDialog(this, "密码太短");
				return;
			}
			
			if(!pwd.equals(pwd2))
			{
				JOptionPane.showMessageDialog(this, "两次密码不相同");
				return;
			}
			
			if(name==null)
			{
				JOptionPane.showMessageDialog(this, "昵称不能为空");
				return;
			}
			
			this.register();
			
		}
		
		else {
			this.dispose();
			new Login();
		}
	}


}
