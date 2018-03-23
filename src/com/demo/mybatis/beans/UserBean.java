package com.demo.mybatis.beans;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private double account;
	public UserBean() {
		super();
	}
	public UserBean(String username, String password, double account) {
		super();
		this.username = username;
		this.password = password;
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ "]";
	}
	

}
