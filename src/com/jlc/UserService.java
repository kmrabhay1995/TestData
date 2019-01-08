package com.jlc;

import java.util.List;

public interface UserService {

	public void addUser(UserTO ut);
	public boolean delete(String uname);
	boolean verify(String uname, String pass);
	UserTO update(String uname);
	void updateafter(UserTO ut, String uname);
	List searchUser(String uname);
	String forgotPass(String uname,String fname,String mname);
	boolean adminVerify(String uname,String pass);
	List<UserTO> getAllUser();
	List<UserTO> getAllUserByAddress(String add);
}
