package com.jlc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public void addUser(UserTO ut) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User u=new User(ut.getUname(),ut.getPass(),ut.getFname(),ut.getMname(),ut.getPhone()
				,ut.getAddress(),ut.getAdhar());
		
		s.save(u);
		tx.commit();
		s.close();
		
	}
	
	
	@Override
	public void updateafter(UserTO ut,String uname) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User u=(User) s.load(User.class, uname);
		u=new User(ut.getUname(),ut.getPass(),ut.getFname(),ut.getMname(),ut.getPhone()
				,ut.getAddress(),ut.getAdhar());
		System.out.println("addd is "+ut.getAddress());
		s.update(u);
		tx.commit();
		s.close();

	}


	@Override
	public boolean deleteUser(String uname) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User u=(User) s.load(User.class,uname);
		s.delete(u);
		tx.commit();
		s.close();
		return true;
	}
	
	

	@Override
	public List<UserTO> getAllUser() {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hql="from User";
		Query q=s.createQuery(hql);
		List<UserTO> ut=q.list();
		tx.commit();
		s.close();
		return ut;
	}
	
	@Override
	public List<UserTO> getAllUserByAddress(String add) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hql="from User where address=?";
		Query q=s.createQuery(hql);
		q.setParameter(0, add);
		List<UserTO> ut=q.list();
		tx.commit();
		s.close();
		return ut;
	}
	
	

	@Override
	public User forgot(String uname) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User u=(User) s.load(User.class,uname);
		u.getAdd();
		tx.commit();
		s.close();
		return u;
	}
	

	@Override
	public List<UserTO> searchUser(String uname) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hql="from User us where us.uname=?";
		Query q=s.createQuery(hql);
		q.setParameter(0, uname);
		List<UserTO> l=q.list();
		tx.commit();
		s.close();
		return l;
		
	}
	
	
	@Override
	public UserTO update(String uname) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User u=(User) s.load(User.class,uname);
		UserTO uto=new UserTO(u.getUname(),u.getPass(),u.getFname(),u.getMname(),u.getPhone(),u.getAdd(),u.getAdhar());
		return uto;
	}
	
	@Override
	public boolean verify(String uname,String pass) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
	
		User u=(User) s.load(User.class,uname);
		String passv=u.getPass();
		tx.commit();
		s.close();
		
		if(passv.equals(pass))
		return true;
		else
		return false;
	}
}
