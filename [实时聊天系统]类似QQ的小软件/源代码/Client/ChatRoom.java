package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.lang.model.element.Element;
import javax.swing.*;

import java.net.*;
import Util.Mtype;
import Util.Customer;
import Util.Message;

public class ChatRoom extends JFrame implements Runnable, ActionListener, Serializable {

	ChatFrame chatFrame = null;

	private boolean flag = true;

	private JLabel jlb1 = new JLabel("                       当 前 在 线 用 户");
	private JLabel jlb2 = new JLabel("                          系  统  消  息");
	private List onlineList = new List();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);

	private JPanel jpl1 = new JPanel(new BorderLayout());
	private JPanel jpl2 = new JPanel(new BorderLayout());
	private JPanel jpl3 = new JPanel(new FlowLayout());
	private JPanel jpl = new JPanel(new GridLayout(1, 2));

	private JButton jbt1 = new JButton("发起聊天");
	private JButton jbt2 = new JButton("传送文件");

	private Socket socket = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private String account;
	private String name;

	public ChatRoom(String account, String name, Socket socket, ObjectInputStream ois, ObjectOutputStream oos,
			Message message) {

		this.account = account;
		this.name = name;
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;

		this.add(jpl);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(500, 250);
		this.setSize(600, 500);
		this.setTitle(account + "  (" + name + ")");

		jpl.add(jpl1);
		jpl.add(jpl2);

		jpl1.add(jlb1, BorderLayout.NORTH);
		jpl1.add(onlineList, BorderLayout.CENTER);
		jpl1.add(jpl3, BorderLayout.SOUTH);

		jpl2.add(jlb2, BorderLayout.NORTH);
		jpl2.add(jsp, BorderLayout.CENTER);

		jpl3.add(jbt1);
		jpl3.add(jbt2);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);

		jta.setEditable(false);
		onlineList.setBackground(Color.GRAY);
		jta.setBackground(Color.GRAY);
		jsp.setBackground(Color.GRAY);
		initOnlineList(message);
		new Thread(this).start();
	}

	public void initOnlineList(Message mess) {

		onlineList.removeAll();
		onlineList.add("广 播 消 息");
		onlineList.select(0);
		Vector<Customer> customers = (Vector<Customer>) mess.getContent();
		for (Customer customer : customers) {
			onlineList.add(customer.getAccount() + "（" + customer.getName() + "）");
		}

	}

	@Override
	public void run() {
		try {
			while (flag) {
				Message returnMessage = (Message) ois.readObject();
				String type = returnMessage.getType();
				if (type.equals(Mtype.USERLIST)) {

					jta.append("\n" + "系统提示：" + returnMessage.getFrom() + "(" + returnMessage.getOthers() + ")" + " 上线"
							+ "\n" + "\n");
					initOnlineList(returnMessage);
				} else if (type.equals(Mtype.LOGOUT)) {
					Customer customer = (Customer) returnMessage.getContent();
					jta.append("\n" + "系统提示：" + customer.getAccount() + "(" + customer.getName() + ")" + " 下线" + "\n"
							+ "\n");
					Thread.sleep(500);
					onlineList.remove(customer.getAccount() + "（" + customer.getName() + "）");
				} else if (type.equals(Mtype.MESSAGE)) {
					String fileName = account + returnMessage.getFrom() + ".txt";
					File file = new File(fileName);
					FileOutputStream fos = new FileOutputStream(file, true);
					PrintStream pStream = new PrintStream(fos);
					pStream.println("[" + returnMessage.getOthers() + "]：" + (String) returnMessage.getContent());
					pStream.close();
					if (chatFrame == null||chatFrame.account.equals(Mtype.ALL)) {
						jta.append("消息通知：" + returnMessage.getFrom() + "(" + returnMessage.getOthers() + ")"
								+ " 给你发来了新消息" + "\n");
					} else {						
						chatFrame.appendMessage((String) returnMessage.getContent());
					}

				}
				else if(type.equals(Mtype.FILE)){
					String fileName  = returnMessage.getFile();
					byte[] fileStream =  (byte[])returnMessage.getContent();
					File file = new File(fileName);
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					fileOutputStream.write(fileStream);
					fileOutputStream.close();
					jta.append("文件通知：" + returnMessage.getFrom() + "(" + returnMessage.getOthers() + ")" +  " 给你传来了文件" + "\n");
				}
				else if(type.equals(Mtype.Error)){
					JOptionPane.showMessageDialog(this, "出现未知错误：格式错误");
				}
				else {
					JOptionPane.showMessageDialog(this, "出现未知错误：Dangerous");
					flag = false;
					System.exit(0);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "您已被强制下线");
			flag = false;
			System.exit(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbt1)
		{
			String whos = onlineList.getSelectedItem();
			
			if(whos.equals("广 播 消 息"))
			{
				chatFrame = new ChatFrame(account, name,Mtype.ALL,null, socket, ois, oos,this);
		
			}
			else {
				String hisaccount = whos.split("（")[0];
				System.out.println(hisaccount);
				if(hisaccount.equals(account))
				{
					JOptionPane.showMessageDialog(this, "不能自己发送给自己消息");
					return;
				}
			String hisname = whos.split("（")[1].split("）")[0];
			chatFrame = new ChatFrame(account, name,hisaccount,hisname, socket, ois, oos,this);
	
			}
			
				
			
			
			
			
		}
		
		else{
String whos = onlineList.getSelectedItem();
			
	String hisaccount;
			if(whos.equals("广 播 消 息"))
			{
				hisaccount = Mtype.ALL;
		
			}
			else {
				hisaccount = whos.split("（")[0];
			}
				if(hisaccount.equals(account))
				{
					JOptionPane.showMessageDialog(this, "不能自己发送给自己文件");
					return;
				}
	
			JFileChooser jfc = new JFileChooser("/Users/apple/Documents");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.showOpenDialog(null);

			File file = jfc.getSelectedFile();
			if (file == null) {
				return;
			}

			String file_name = file.getName();
			byte[] fileStream;
			try{
				 fileStream = new byte[(int)file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(fileStream);
			fileInputStream.close();
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "文件错误");
				return;
			}
			
			
			
			Message message = new Message();
			message.setType(Mtype.FILE);
			message.setFrom(account);
			message.setTo(hisaccount);
			message.setOthers(name);
			message.setContent(fileStream);
			message.setSize((int)file.length());
			message.setFile(file_name);
			try{
				oos.writeObject(message);
			JOptionPane.showMessageDialog(this, "文件发送成功");
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "文件发送失败");
				return;
			}
			
		
			
		
		
	}

}
}
