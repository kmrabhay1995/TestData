package com.jlc;

import java.util.List;

public interface UserDAO {

	public void addUser(UserTO ut);

	boolean deleteUser(String uname);

	boolean verify(String uname, String pass);

	UserTO update(String uname);

	void updateafter(UserTO ut, String uname);

	List<UserTO> searchUser(String uname);

	User forgot(String uname);

	List<UserTO> getAllUser();

	List<UserTO> getAllUserByAddress(String add);
}
