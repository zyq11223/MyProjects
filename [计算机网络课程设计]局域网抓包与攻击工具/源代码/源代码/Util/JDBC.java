package Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC {

	
public static int LoginCharge(String acc,String pwd) {
	
	try {
		//连接数据库
	Class.forName(Parameter.JDBC_DRIVER);
	Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
	Statement stat = conn.createStatement();

	String query = "select * from `" + Parameter.COMPANY + "` where acc=\"" + acc + "\"";
	ResultSet rs = stat.executeQuery(query);
	if (!rs.next()) 
		return 1;//账号不存在
	
	String pwd2 = rs.getString("pwd");
	if(!pwd2.equals(pwd))
		return 2;//密码不正确
	
	String table = rs.getString("table");
	return 0;
	}catch (Exception e) {
		e.printStackTrace();
		return 3;
	}
	
	
	
	
	
	
	
}
	
	
	
	
	
	

	

}