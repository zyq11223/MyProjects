package Util;

import java.io.Serializable;

public class Customer implements Serializable{
	private String account;
	private String password;
	private String name;
	
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPwd(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;	
	}
	
	public String getAccount() {
		return(this.account);
		
	}
	
	public String getPwd() {
		return(this.password);
		
	}
	
	public String getName() {
		return(this.name);
	}
}
