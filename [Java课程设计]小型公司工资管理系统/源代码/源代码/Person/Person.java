package Person;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;

import javax.swing.JOptionPane;

import Util.*;

public class Person {

	private String ID;
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String department;
	private int kind;
	private int hours;
	private double sells;
	private double salary;
	
	public Person(String ID,String name,String sex,int age,String phone,
						  String department,int kind,int hours,double sells) {
		this.ID = ID;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.department = department;
		this.kind = kind;
		this.hours = hours;
		this.sells = sells;
		
		switch (kind) {
case 1:
			this.salary = Parameter.BASE;
break;

case 2:
			this.salary = Parameter.HOUR*hours;
break;

case 3:
			this.salary = Parameter.Parameter*sells;
break;

case 4:
			this.salary = Parameter.BASE + Parameter.Parameter*sells;
break;

		default:
			return;
		}
		
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0");  
		df.format(salary);
	}
	
	public String getID() {
		return ID;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getDep() {
		return department;
	}
	
	public int getKind() {
		return kind;
	}
	
	public int getHours() {
		return hours;
	}
	
	public double getSells() {
		return sells;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
	
	
	
}
