package com.jlc;

public class UserTO {
	private String uname;
	private String pass;
	private String fname;
	private String mname;
	private String phone;
	private String address;
	private String adhar;
	
	public UserTO() {
	}
	
	
	public UserTO(String uname, String pass, String fname, String mname, String phone, String address, String adhar) {
		this.uname = uname;
		this.pass = pass;
		this.fname = fname;
		this.mname = mname;
		this.phone = phone;
		this.address = address;
		this.adhar = adhar;
	}
	


	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	
}
