package Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Person.Person;

public class JDBC {

	
public static int LoginCharge(String acc,String pwd) {
	
	try {
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
	Parameter.TABLE = table;
	return 0;
	}catch (Exception e) {
		e.printStackTrace();
		return 3;
	}
	
	
	
	
	
	
	
}
	
	
	
	
	
	public static int insertIntoSql(Person p) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			// 判断是否已经存在编号
			String query1 = "select * from `" + Parameter.TABLE + "` where no=\"" + p.getID() + "\"";
			ResultSet rs = stat.executeQuery(query1);
			if (rs.next()) {
				return 1;
			}

			String query = "INSERT INTO `" + Parameter.TABLE + "` VALUES (\"" + p.getID() + "\",\"" + p.getName()
					+ "\",\"" + p.getSex() + "\",\"" + p.getAge() + "\",\"" + p.getPhone() + "\",\"" + p.getDep()
					+ "\",\"" + p.getKind() + "\",\"" + p.getHours() + "\",\"" + p.getSells() + "\",\"" + p.getSalary()
					+ "\")";
			stat.executeUpdate(query);

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(query);
			ps.close();
			return 0;

		} catch (Exception expt) {
			return 2;
		}

	}

	public static int deleteFromsql(String id) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			String query1 = "select * from `" + Parameter.TABLE + "` where no=\"" + id + "\"";

			ResultSet rs = stat.executeQuery(query1);

			if (!rs.next()) {
				return 1;
			}

			String query2 = "delete from `" + Parameter.TABLE + "` where no=\"" + id + "\"";
			stat.executeUpdate(query2);

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(query1);
			ps.println(query2);
			ps.close();
			return 0;

		} catch (Exception expt) {
			return 2;
		}

	}

	public static String searchByID(String id) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			String query1 = "select * from `" + Parameter.TABLE + "` where no=\"" + id + "\"";

			ResultSet rs = stat.executeQuery(query1);

			if (!rs.next()) {
				return null;
			}

			String name = rs.getString("name");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String phone = rs.getString("phone");
			String department = rs.getString("department");
			int kind = rs.getInt("kind");
			int hours = rs.getInt("hours");
			double sells = rs.getDouble("sales");
			double salary = rs.getDouble("salary");

			String result = id + "@" + name + "@" + sex + "@" + age + "@" + phone + "@" + department + "@" + kind + "@"
					+ hours + "@" + sells + "@" + salary;

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			return "Fail";
		}

	}

	public static String searchByOthers(String chosen, String others) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (chosen.equals("age") || chosen.equals("kind"))
				query = "select * from `" + Parameter.TABLE + "` where " + chosen + "=\"" + Integer.parseInt(others)
						+ "\"";
			else
				query = "select * from `" + Parameter.TABLE + "` where " + chosen + "=\"" + others + "\"";

			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			String id = rs.getString("no");
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String phone = rs.getString("phone");
			String department = rs.getString("department");
			int kind = rs.getInt("kind");
			int hours = rs.getInt("hours");
			double sells = rs.getDouble("sales");
			double salary = rs.getDouble("salary");

			String result = id + "@" + name + "@" + sex + "@" + age + "@" + phone + "@" + department + "@" + kind + "@"
					+ hours + "@" + sells + "@" + salary;

			while (rs.next()) {
				id = rs.getString("no");
				sex = rs.getString("sex");
				name = rs.getString("name");
				age = rs.getInt("age");
				phone = rs.getString("phone");
				department = rs.getString("department");
				kind = rs.getInt("kind");
				hours = rs.getInt("hours");
				sells = rs.getDouble("sales");
				salary = rs.getDouble("salary");
				result += "#" + id + "@" + name + "@" + sex + "@" + age + "@" + phone + "@" + department + "@" + kind
						+ "@" + hours + "@" + sells + "@" + salary;
			}

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			return "Fail";
		}

	}

	public static int UpdateFromsql(Person newP, Person oldP) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			if (deleteFromsql(oldP.getID()) != 0) {
				return 1;
			}

			String query1 = "select * from `" + Parameter.TABLE + "` where no=\"" + newP.getID() + "\"";

			ResultSet rs = stat.executeQuery(query1);

			if (rs.next()) {
				if (insertIntoSql(oldP) != 0)
					JOptionPane.showMessageDialog(null, "发生未知错误");
				return 2;
			}

			if (insertIntoSql(newP) != 0) {
				if (insertIntoSql(oldP) != 0)
					JOptionPane.showMessageDialog(null, "发生未知错误");
				return 3;
			}

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(query1);
			ps.close();
			return 0;

		} catch (Exception expt) {
			if (insertIntoSql(oldP) != 0)
				JOptionPane.showMessageDialog(null, "发生未知错误");
			return 4;
		}

	}

	public static String searchAll() {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			String query = "select * from `" + Parameter.TABLE + "` ";

			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			String id = rs.getString("no");
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String phone = rs.getString("phone");
			String department = rs.getString("department");
			int kind = rs.getInt("kind");
			int hours = rs.getInt("hours");
			double sells = rs.getDouble("sales");
			double salary = rs.getDouble("salary");

			String result = id + "@" + name + "@" + sex + "@" + age + "@" + phone + "@" + department + "@" + kind + "@"
					+ hours + "@" + sells + "@" + salary;

			while (rs.next()) {
				id = rs.getString("no");
				name = rs.getString("name");
				sex = rs.getString("sex");
				age = rs.getInt("age");
				phone = rs.getString("phone");
				department = rs.getString("department");
				kind = rs.getInt("kind");
				hours = rs.getInt("hours");
				sells = rs.getDouble("sales");
				salary = rs.getDouble("salary");
				result += "#" + id + "@" + name + "@" + sex + "@" + age + "@" + phone + "@" + department + "@" + kind
						+ "@" + hours + "@" + sells + "@" + salary;
			}

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			return "Fail";
		}

	}

	public static int statisticCount(String option) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();



			String query =  "select count(*) from `" + Parameter.TABLE + "` "+option;
			
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}
			int result = Integer.parseInt(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static int statisticKindCount(int kind, String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			String query = "select count(*) from `" + Parameter.TABLE + "` where kind=" + kind + option1 + option2;

			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()) {
				return 0;
			}
			int result = Integer.parseInt(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static int statisticSexCount(String sex, String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();

			String query = "select count(*) from `" + Parameter.TABLE + "` where sex=\"" + sex + "\"" + option1
					+ option2;

			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()) {
				return 0;
			}
			int result = Integer.parseInt(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static double statisticAvgSalary(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1.length() <= 0 && option2.length() <= 0)
				query = "select AVG(salary) from `" + Parameter.TABLE + "` ";
			else if (option2.length() <= 0) {
				query = "select AVG(salary) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select AVG(salary) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select AVG(salary) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			double result = Double.parseDouble(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static double statisticMaxSalary(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1.length() <= 0 && option2.length() <= 0)
				query = "select MAX(salary) from `" + Parameter.TABLE + "` ";
			else if (option2.length() <= 0) {
				query = "select MAX(salary) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select MAX(salary) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select MAX(salary) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			double result = Double.parseDouble(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static double statisticMinSalary(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1.length() <= 0 && option2.length() <= 0)
				query = "select MIN(salary) from `" + Parameter.TABLE + "` ";

			else if (option2.length() <= 0) {
				query = "select MIN(salary) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select MIN(salary) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select MIN(salary) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			double result = Double.parseDouble(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static double statisticAvgAge(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1.length() <= 0 && option2.length() <= 0)
				query = "select AVG(age) from `" + Parameter.TABLE + "` ";

			else if (option2.length() <= 0) {
				query = "select AVG(age) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select AVG(age) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select AVG(age) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			double result = Double.parseDouble(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static int statisticMaxAge(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1==null&&option2==null||option1.length() <= 0 && option2.length() <= 0)
				query = "select MAX(age) from `" + Parameter.TABLE + "` ";

			else if (option2.length() <= 0) {
				query = "select MAX(age) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select MAX(age) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select MAX(age) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
	
		
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			int result = Integer.parseInt(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

	public static int statisticMinAge(String option1, String option2) {
		try {
			Class.forName(Parameter.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(Parameter.DB_URL, Parameter.ACC, Parameter.PWD);
			Statement stat = conn.createStatement();
			String query;
			if (option1.length() <= 0 && option2.length() <= 0)
				query = "select MIN(age) from `" + Parameter.TABLE + "` ";

			else if (option2.length() <= 0) {
				query = "select MIN(age) from `" + Parameter.TABLE + "` where " + option1;

			} else if (option1.length() <= 0) {
				query = "select MIN(age) from `" + Parameter.TABLE + "` where " + option2;

			} else {
				query = "select MIN(age) from `" + Parameter.TABLE + "` where " + option1 + " and " + option2;


			}
			ResultSet rs = stat.executeQuery(query);

			if (!rs.next()||rs.getString(1)==null) {
				return 0;
			}

			int result = Integer.parseInt(rs.getString(1));

			// 生成日志
			File f = new File("log.txt");
			if (!f.exists())
				f.createNewFile();
			PrintStream ps = new PrintStream(new FileOutputStream(f));
			ps.println(result);
			ps.close();
			return result;

		} catch (Exception expt) {
			expt.printStackTrace();
			JOptionPane.showMessageDialog(null, "发生未知错误");
			return 0;
		}

	}

}