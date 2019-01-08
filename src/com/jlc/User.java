package com.jlc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {
	@Id
	private String uname;
	@Column(length=20)
	private String pass;
	@Column(length=20)
	private String fname;
	@Column(length=20)
	private String mname;
	@Column(length=20)
	private String phone;
	@Column(length=20)
	private String address;
	@Column(length=20)
	private String adhar;
	
	public User()
	{
		
	}
	
	public User(String uname, String pass, String fname, String mname, String phone, String address, String adhar) {
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
	public String getAdd() {
		return address;
	}
	public void setAdd(String address) {
		this.address = address;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	
}
