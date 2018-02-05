package Server;

import java.beans.Customizer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Vector;

import Util.Customer;
import Util.Message;
import Util.Mtype;

public class ChatCustomer implements Runnable,Serializable {

	Socket socket = null;
	Connection server = null;
	Customer customer = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	boolean flag = true;

	public ChatCustomer(Socket socket, Connection server) throws Exception {
		this.server = server;
		this.socket = socket;
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (flag) {
			 
			
			try {
				Message message = (Message) ois.readObject();
			
			
			String type = message.getType();
			if (type.equals(Mtype.LOGIN)) {
				
				Login(message);

			} else if (type.equals(Mtype.REGISTER)) {

				Register(message);
				
			} else if (type.equals(Mtype.MESSAGE)||type.equals(Mtype.FILE)) {
				
				sendMessage(message, message.getTo());

			}
			else{
				ErrorCommand(message);
			}
			} 
			catch (Exception e) {
				if(this.customer!=null)
				Logout();
			}
		}
	}
	
	public void Login(Message message) throws Exception{
		
		Customer cus = (Customer) message.getContent();
		String account = cus.getAccount();
		String pwd = cus.getPwd();
		Customer cus2 = FileOpen.getCustomerByAccount(account);
		Message returnMessage = new Message();
		if(cus2==null || !cus2.getPwd().equals(pwd))
		{
			//登录失败，用户名错误或密码错误
			returnMessage.setType(Mtype.LOGINFALL);
			returnMessage.setContent("用户名或密码错误");
			oos.writeObject(returnMessage);
			flag =false;
			socket.close();
			return;
		}
		
		
		Vector<Customer> online = server.getOnlineUsers();
		for(Customer c0:online)
		{
			if(c0.getAccount().equals(cus.getAccount()))
			{
				//登录失败，该账号已在线
				returnMessage.setType(Mtype.LOGINFALL);
				returnMessage.setContent("该账号已在线");
				oos.writeObject(returnMessage);
				flag =false;
				socket.close();
				return;
			}
		}
		
		
		
		
		this.customer = cus2;
		
		//在线程池中加入该用户
		server.getUsers().add(this);
		//在在线用户列表中加入该用户
		server.getOnlineUsers().add(this.customer);
		
		//返回给所有用户在线用户列表,Update
		returnMessage.setType(Mtype.USERLIST);
		returnMessage.setContent(server.getOnlineUsers().clone());
		returnMessage.setFrom(cus2.getAccount());
		returnMessage.setOthers(cus2.getName());
		oos.writeObject(returnMessage);
		this.sendMessage(returnMessage,Mtype.ALL);
		server.setTitle("当前在线"+server.getOnlineUsers().size()+"人");
		
	}
	
	public void Register(Message message) throws Exception{
		
		Message returnMessage = new Message();
		Customer cus = (Customer) message.getContent();
		String account = cus.getAccount();
		
		Customer cus2 = FileOpen.getCustomerByAccount(account);
		if(cus2!=null)
		{
			returnMessage.setType(Mtype.REGISTERFALL);
			
		}
		else {
			FileOpen.insertCustomer(account, cus.getPwd(), cus.getName());
			returnMessage.setType(Mtype.REGISTERSUCCESS);			
		}
		oos.writeObject(returnMessage);
		flag = false;
		socket.close();
		
		
	}
		
	public void Logout() {
		Message message = new Message();
		message.setType(Mtype.LOGOUT);
		message.setContent(this.customer);
		server.getUsers().remove(this);
		server.getOnlineUsers().remove(this.customer);
		server.setTitle("当前在线"+server.getOnlineUsers().size()+"人");
		try{
			sendMessage(message, Mtype.ALL);
			flag = false;
			socket.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void ErrorCommand(Message message) throws Exception{
	Message returnMessage = new Message();
	returnMessage.setType(Mtype.Error);
	oos.writeObject(returnMessage);
	flag = false;
	socket.close();
	
		
	}
	public void sendMessage(Message message,String to) throws Exception{
		for(ChatCustomer chatCustomer   :    server.getUsers())
		{
			if(chatCustomer.customer.getAccount().equals(this.customer.getAccount()))
				continue;
			if(chatCustomer.customer.getAccount().equals(to)||  to.equals(Mtype.ALL))
			{
				chatCustomer.oos.writeObject(message);
			}
		}
		
	}

}
