package Server;

import java.io.*;
import java.net.*;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Util.Customer;
import Util.Mtype;

public class Connection extends JFrame implements Runnable,Serializable{
	
	private ServerSocket serverSocket  = null;
	private Socket socket = null;
	private Vector<ChatCustomer> users = new Vector<ChatCustomer>();
	private Vector<Customer> online_users = new Vector<Customer>();
	
	public Connection() {
		
		this.setVisible(true);
		this.setTitle("当前在线"+online_users.size()+"人");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(200,200);
		
		try{
			System.out.println("no");
			serverSocket = new ServerSocket(Mtype.PORT);
			System.out.println("yes");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "服务器链接出错");
			e.printStackTrace();
		}
		
		
		new Thread(this).start();
		
		
	}
	
	
	@Override
	public void run() {
		
		while (true)
		{
			try {
				 socket = serverSocket.accept();
				ChatCustomer chatcus = new ChatCustomer(socket,this);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "服务器链接出错");
				try{
					serverSocket.close();
				}catch (Exception ex) {
					// TODO: handle exception
				}
				

			}
		}
		
	}
	
	
	public Vector<ChatCustomer> getUsers() {
		return users;
	}
	
	public Vector<Customer> getOnlineUsers() {
		return online_users;
	}

}
