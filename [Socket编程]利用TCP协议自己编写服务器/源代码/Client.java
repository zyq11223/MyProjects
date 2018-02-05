import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.channels.ScatteringByteChannel;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Client extends JFrame{
	Socket socket =null;
   



	public void put() throws Exception{
	//选择要上传的文件
	JFileChooser jfc=new JFileChooser("/Users/apple/Documents/eclipse/Socket");
	jfc.setFileSelectionMode(JFileChooser.FILES_ONLY  );
	jfc.showOpenDialog(null);
	
	File file=jfc.getSelectedFile();
	if(file==null){return;}
	
	String file_name=file.getName();
	byte[] b4 = new byte[file_name.length()];
	b4=file_name.getBytes("utf-8");
	
	 
	 FileInputStream fis = new FileInputStream(file);
     byte[] File = new byte[(int)file.length()];
     fis.read(File);
     fis.close();
	
 
     
     byte[] encrypt = Encrypt.encrypt(File, file_name);
     
	
	 byte b1=2;
	 byte b2=(byte)file_name.length();
	 int b3=(int)encrypt.length;
	
	
	DataOutputStream os = new DataOutputStream(socket.getOutputStream());
    os.writeByte(b1);//发出上传文件的请求
	os.writeByte(b2);//发出文件名大小
	os.writeInt(b3);//发出上传文件的大小 
	os.write(b4);//发出上传的文件名字，为bytes流
	os.write(encrypt);//发出上传的文件，为bytes流
	
	
	DataInputStream dis = new DataInputStream(socket.getInputStream());

	//接收服务器回执消息
	byte flag = dis.readByte();
	
	short info_size = dis.readShort() ; 
	byte[] info = new byte[info_size];
	dis.read(info);
	String string2 = new String(info);
	if(flag==0)
		new JOptionPane().showMessageDialog(null, string2+'\n'+"文件发送失败!");
	
	else new JOptionPane().showMessageDialog(null, string2+'\n'+"文件已成功发送!");
	
}
	
	public int get(String file_name) throws Exception{
		//从服务器下载文件
		OutputStream os = socket.getOutputStream();

		byte b1=0;
		
		String fString=file_name;
		byte[] name = fString.getBytes();
		
		int size = name.length;
		
		//按格式发送请求和文件
		os.write(b1);
		os.write(size);
		os.write(name);
	    
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		byte flag = dis.readByte();
		
		if(flag==0)return flag;//文件名输入错误
		
		 JOptionPane wait = new JOptionPane();
		 
				wait.showMessageDialog(this, "按确认键开始下载：");
			
		
		int file_size =	dis.readInt();

		byte[] encrypt = new byte[file_size];
		//选择保存文件的目录
		JFileChooser jf = new JFileChooser("/Users/apple/Documents/eclipse/Socket");  
		jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);  
		jf.showSaveDialog(null);
		File fi = jf.getSelectedFile();  
		String path = fi.getPath();
		
		File new_file = new File(fi,file_name);
		
		FileOutputStream fos = new FileOutputStream(new_file);
		
		
			 dis.readFully(encrypt);
			 
			 byte[] decrypt = Decrypt.decrypt(encrypt, file_name);
	     	  fos.write(decrypt);//保存文件
			  fos.close();
			  
			//从服务器接收传来的消息
				  byte[] mes = new byte[1024];
				  dis.read(mes);
		
				  String str2 = new String(mes);	
				  
		          wait.showMessageDialog(null,"文件已成功下载!");
		          
	               return 1;
}
	
	public String listAll() throws Exception{
		//从服务器得到文件列表
	OutputStream os = socket.getOutputStream();
	
	//向服务器发送请求
	byte b1[]=new byte[1];
	b1[0]=1;
	os.write(b1);
	
InputStream is = socket.getInputStream();
DataInputStream dis = new DataInputStream(is);

	byte flag = dis.readByte();//8位
	short info_size =	dis.readShort();//16位
	
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	 String str_show="";
	 
	while(true)//error
	  { 
		  String str = br.readLine();
		
		  if(str.equals("%$#"))break;
		  str_show +=str+'\n';
	
	  }
	
	return str_show;
}
	
	public String pre_list()throws Exception {
		//为方便得到服务器上传和下载的文件列表，此函数保留以便今后添加新功能
		String str_list = this.listAll();
	
		return str_list;
	
		
		
		
		
		
		
	}
	
	public  void count() {
		
		
		
	}
	
	public Client() {
		try
		{//"202.197.61.231"
			socket = new Socket("127.0.0.1",10086);//连接到服务器
			}
		catch (Exception e) 
		{
			new JOptionPane().showMessageDialog(this, "连接失败");
			System.exit(0);
		}
		
	}
	
	
	
	
}
