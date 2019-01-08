package com.jlc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService {

	@Autowired
	UserDAO ud;
	
	@Override
	public void addUser(UserTO ut) {
		ud.addUser(ut);
		
	}

	@Override
	public boolean delete(String uname) {
		boolean x=ud.deleteUser(uname);
		return x;
	}

	@Override
	public boolean verify(String uname, String pass) {
		boolean x=ud.verify(uname, pass);
		return x;
	}

	@Override
	public UserTO update(String uname) {
		UserTO ut=ud.update(uname);
		return ut;
			}

	@Override
	public void updateafter(UserTO ut, String uname) {
		ud.updateafter(ut, uname);
		
	}

	@Override
	public List searchUser(String uname) {
		List<UserTO> l=ud.searchUser(uname);
		return l;
	}

	@Override
	public String forgotPass(String uname, String fname, String mname) {
		User u=ud.forgot(uname);
		if(u.getFname().equals(fname) && u.getMname().equals(mname))
			return "Your password is: "+u.getPass();
		else 
			return "Please Enter Correct info";
	}

	@Override
	public boolean adminVerify(String uname, String pass) {
		if(uname.equals("abhay") && pass.equals("prince"))
			return true;
		else 
			return false;
	}

	@Override
	public List<UserTO> getAllUser() {
		List<UserTO> li=ud.getAllUser();
		return li;
	}

	@Override
	public List<UserTO> getAllUserByAddress(String add) {
		List<UserTO> li=ud.getAllUserByAddress(add);
		return li;
	}

	

}
