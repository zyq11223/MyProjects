import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.channels.ScatteringByteChannel;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.awt.*;
import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Sever extends JFrame {
	ServerSocket serverSocket = null;
	Socket socket = null;

	ArrayList<Socket_connect> socket_connects = new ArrayList<Socket_connect>();

	public Sever() throws Exception {

		
		JOptionPane.showMessageDialog(this, "请选择服务器文件目录");
		JFileChooser jf = new JFileChooser("/Users/apple/Documents/eclipse/Project1");
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jf.showOpenDialog(null);
		File file = jf.getSelectedFile();
		String path = file.getAbsolutePath();
		serverSocket = new ServerSocket(10086);// 开辟端口，等待客户端连接
		this.setSize(150, 150);
		this.setTitle("服务器");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	
		 

		// 利用线程池，启动线程
		Executor executor = Executors.newFixedThreadPool(100);
		executor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						socket = serverSocket.accept();

						Socket_connect socket_connect = new Socket_connect(socket, path);
						socket_connects.add(socket_connect);// 防止被回收
						socket_connect.start();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	public static void main(String[] args) throws Exception {
		new Sever();
	}

}
