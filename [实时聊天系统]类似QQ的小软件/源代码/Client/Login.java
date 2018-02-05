package Client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.net.*;
import Util.Mtype;
import Util.Customer;
import Util.Message;

public class Login extends JFrame implements ActionListener,Serializable{
	
	private JLabel lbAccount = new JLabel("帐号： ");
	private JTextField jtAccount = new JTextField(10);
	private JLabel lbPwd = new JLabel("密码： ");
	private JPasswordField jtPwd = new JPasswordField(10);
	private JButton login = new JButton("登 陆");
	private JButton registe = new JButton("注册");
	
	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	
	public Login() {
		this.setTitle("登 陆");
		this.setLayout(new FlowLayout());
		
		this.add(lbAccount);
		this.add(jtAccount);
		
		this.add(lbPwd);
		this.add(jtPwd);
		
		this.add(login);
		this.add(registe);
		
		this.setLocation(600,300);
		this.setSize(200,130);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		login.addActionListener(this);
		registe.addActionListener(this);
		
	}


	public void loginToChatroom()
	{
		
		String account = jtAccount.getText();
		String pwd = new String(jtPwd.getPassword());
		Customer cus = new Customer();
		cus.setAccount(account);
		cus.setPwd(pwd);
		
		Message message = new Message();
		message.setType(Mtype.LOGIN);
		message.setContent(cus);
		String name;
		
		try {
			
			socket = new Socket(Mtype.IP, Mtype.PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(message);
			
			Message returnMessage = (Message)ois.readObject();
			String type = returnMessage.getType();
			
			if(type.equals(Mtype.LOGINFALL))
			{
				JOptionPane.showMessageDialog(this, "登录失败"+'\n'+(String)returnMessage.getContent());
				socket.close();
				return;
			}
			else{
				JOptionPane.showMessageDialog(this, "登录成功");
				name = returnMessage.getOthers();
				
				this.dispose();
				Thread.sleep(500);
				
				 new ChatRoom(account,name,socket,ois,oos,returnMessage);

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "网络异常");
			System.exit(0);
		}
		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login)
			this.loginToChatroom();
		else{
			this.dispose();
			new Register();
		}
		
	}		
	
	
	
	

	
	
	
}
