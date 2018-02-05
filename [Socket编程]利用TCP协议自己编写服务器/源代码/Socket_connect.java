import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.tools.Diagnostic;

public class Socket_connect extends Thread{

	
	Socket socket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	String path = "";
	public Socket_connect(Socket s,String str) throws Exception{
		socket=s;
		path=str;
		choose();
	}
	
public void choose() throws Exception{
		
		dis = new DataInputStream(socket.getInputStream());
		byte type = dis.readByte();
		
		switch (type) {
		case 0:
			send_file();
			break;
		case 1:
			send_list();
			break;
		case 2:
			receive_file();
			break;

		default:error_message("Error:Unknow Command Type");
			break;
		}
	}
	
	public void success_message(String str) throws Exception{
		
		byte reply_type = 1;
		short size_of_info = (short)str.length();
		byte[] info= str.getBytes();
		
		dos.writeByte(reply_type);
		dos.writeShort(size_of_info);
		dos.write(info);
		socket.close();
	}
	
	 public void error_message(String str) throws Exception{
		   dos = new DataOutputStream(socket.getOutputStream());
		    byte reply_type = 0;
			short size_of_info = (short)str.length();
			byte[] info= str.getBytes();
			
			dos.writeByte(reply_type);
			dos.writeShort(size_of_info);
			dos.write(info);
		  socket.close();
		 
		
	}
	
	 public void send_list() throws Exception{//发送文件列表
		 
	
		 File Directory = new File(path);
		 String[] file_name = Directory.list();
		 int file_num = file_name.length;
		 
		 dos = new DataOutputStream(socket.getOutputStream());
		   PrintStream ps =new PrintStream(socket.getOutputStream()); 
		 byte reply_type = 1;
			short size_of_info = 66;
			dos.writeByte(reply_type);
			dos.writeShort(size_of_info);
			String string ="";
		 for(int i=0;i<file_num;i++)
		 {
			string =file_name[i];
			ps.println(string);
		 } 
		 
			ps.println("%$#");  
			  
	
		
	
		
		 
		
	}
	
	 public void receive_file() throws Exception{//获取文件
		 //接收发送到服务器的消息
	
		
		 byte size_Of_Filename = dis.readByte();
		 int file_size = dis.readInt();
		 byte[] filename =new byte[size_Of_Filename];
		
		 dis.readFully(filename);
		  String  saved = new String(filename);
		 
		 byte[] file =new byte[file_size];
		 dis.readFully(file);
		 File new_file =  new File(path,saved);
		
		 FileOutputStream fos = new FileOutputStream(new_file);
			fos.write(file);//保存文件
			
		 dos = new DataOutputStream(socket.getOutputStream());
		 fos.close();
		 success_message("Successful Received the File");

	
	}
	
	 public void send_file() throws Exception{//发送文件
		 
		 byte size_of_filename = dis.readByte();
		 byte[] filename = new byte[size_of_filename];
		 dis.readFully(filename);
		 String file_name = new String(filename);
		 int flag = 0;
		 
		 File Directory = new File(path) ;
		 String[] file_list = Directory.list();
		 int file_num = file_list.length;
		 for(int i=0;i<file_num;i++)
		 {
			 String file = file_list[i].toString();
			 if(file.equals(file_name))
			 {
				 flag=1;
				 break;
			 }
		 }
		 
		 if(flag==0)error_message("Error:File Not Exist.");
		 else if(flag==1)
		 {
			 dos = new DataOutputStream(socket.getOutputStream());
			 byte type = 2;
			 dos.writeByte(type);
			 
			 File file = new File(Directory,file_name);
			 
			
			
			
			  int size_of_file = (int)file.length();
			   byte[] fileBytes = new byte[size_of_file];
			   FileInputStream fis = new FileInputStream(file);
			   fis.read(fileBytes);
			 dos.writeInt(size_of_file);
			 dos.write(fileBytes);
			 
			 success_message("Successful Send the File");
			 
		 }
			 
		 
		 

		
	}
	
	
	
}
