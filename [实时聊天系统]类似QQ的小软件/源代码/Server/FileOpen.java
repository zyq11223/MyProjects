package Server;

import java.beans.Customizer;
import java.io.*;
import java.sql.PseudoColumnUsage;
import java.util.Properties;

import javax.swing.*;

import Util.Customer;

public class FileOpen implements Serializable{

	private static String filename = "Users.txt";
	private static Properties properties;

	static {
		properties = new Properties();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filename);
			properties.load(fileReader);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in File");
			System.exit(0);
		} finally {
			try {
				fileReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	private static void listInfo() {

		PrintStream pStream = null;
		try {
			pStream = new PrintStream(filename);
			properties.list(pStream);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in File");
			System.exit(0);

		} finally {
			try {
				pStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	//根据帐号返回登陆者的信息
	public static Customer getCustomerByAccount(String Account) {
		Customer customer = null;
		String cusinfo = properties.getProperty(Account);
		if(cusinfo!=null)
		{
			customer = new Customer();
			String[] info = cusinfo.split("@#");
			customer.setAccount(Account);
			customer.setPwd(info[0]);
			customer.setName(info[1]);
		}
		
		return customer;
		
	}
	
	
	
	
	public static void insertCustomer(String account,String pwd,String name) {
		
		properties.setProperty(account, pwd+"@#"+name);
		listInfo();
	}
	
	
}
