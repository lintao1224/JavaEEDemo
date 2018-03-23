package com.demo.bean;

public class TUser {
	@Override
	public String toString() {
		return "TUser [uname=" + uname + ", upass=" + upass + "]";
	}
	private String uname;
	private String upass;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	

}
