package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.*;
import java.util.jar.Attributes.Name;

import javax.security.auth.login.AccountException;
import javax.swing.*;

import Util.Message;
import Util.Mtype;

public class ChatFrame extends JFrame implements ActionListener,WindowListener,Serializable{

	private JLabel jlb1 = new JLabel();
	private JTextArea jTextArea = new JTextArea();
	private JScrollPane jScrollPane = new JScrollPane(jTextArea);
	private JTextField jTextField = new JTextField();
	private JButton send = new JButton("发送");
	
	private boolean flag = true;
	private JPanel jpl1 = new JPanel(new BorderLayout());
	private JPanel jpl2 = new JPanel(new BorderLayout());
	
	private Socket socket = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private ChatRoom chatRoom = null;

	private String myaccount = null;
	private String myname = null;
	public String account = null;
	private String name = null;
	
	
	public ChatFrame(String myaccount,String myname,String account,String name,Socket socket,ObjectInputStream ois,ObjectOutputStream oos,ChatRoom chatRoom) {
		
		this.myname = myname;
		this.account = account;
		this.myaccount = myaccount;
		this.name = name;
		this.chatRoom = chatRoom;
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		
		this.add(jpl1);
		this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(400, 150);
		this.setSize(400, 500);
		this.addWindowListener(this);
		
		if(!account.equals(Mtype.ALL))
		this.setTitle("聊 天 记 录  "+account+"  ("+name+")");
		else {
			this.setTitle("广 播 消 息  ");
		}
		
		jpl1.add(jScrollPane, BorderLayout.CENTER);
		jpl1.add(jpl2, BorderLayout.SOUTH);
		
		jpl2.add(jTextField, BorderLayout.CENTER);
		jpl2.add(send, BorderLayout.EAST);
		send.addActionListener(this);
		
		jTextArea.setEditable(false);
		jTextArea.setBackground(Color.GRAY);
		jScrollPane.setBackground(Color.GRAY);
		if(!account.equals(Mtype.ALL))
		{
				try{
			
		File file  = new File(myaccount+account+".txt");
		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);
		while (true) {
			String string = bReader.readLine();
			if(string==null)break;
			jTextArea.append(string.trim()+"\n");
			
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			Message message = new Message();
			message.setType(Mtype.MESSAGE);
			message.setFrom(myaccount);
			message.setTo(account);
			message.setContent((String)jTextField.getText());
			message.setOthers(myname);
			oos.writeObject(message);
			
			jTextArea.append("["+" Me "+"]："+jTextField.getText().trim()+"\n");
			
			if(!account.equals(Mtype.ALL))
			{
				File file = new File(myaccount+account+".txt");
				FileOutputStream fos = new FileOutputStream(file,true);
				PrintStream pStream = new PrintStream(fos);
				pStream.println("["+" Me "+"]："+jTextField.getText());
				pStream.close();
			}
			
			jTextField.setText("");
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "消息发送失败");
		}
		
	}
	
	
	public void appendMessage(String mess) {
		
		if(!account.equals(Mtype.ALL));
		jTextArea.append("["+name+"]："+mess.trim()+"\n");
				
	}

	@Override
	public void windowOpened(WindowEvent e) {
		this.setVisible(true);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "确认关闭？","确认",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION)
		{
			this.dispose();
			chatRoom.chatFrame=null;
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}
