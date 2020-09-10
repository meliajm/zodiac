package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO{

	@Override
	public boolean insert(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			ses.save(u);
			tx.commit();
			
			return true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Users u) {
		Session ses = HibernateUtil.getSession();
		ses.merge(u);
		return true;
	}

	@Override
	public List<Users> findAll() {
		Session ses = HibernateUtil.getSession();
		String hql = "FROM Users";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		List<Users> all = query.list();
		
		return all;
	}

	@Override
	public Users findById(int id) {
		Session ses = HibernateUtil.getSession();
		Users u = ses.get(Users.class, id);
		return u;
	}
	
	public boolean addFollowers(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			List<Users> followers = new ArrayList<Users>();
			followers.add(u);
			
			
			
			tx.commit();
			
			return true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
}
