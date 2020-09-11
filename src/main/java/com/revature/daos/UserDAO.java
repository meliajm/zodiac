package com.revature.daos;

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
			
			ses.update(u);

			return true;

	}
	
	@Override
	public boolean addFollowers(Users u, Users u2) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			if(u == u2) {
				tx.rollback();
				return false;
			} else {
				u.getFollowers().add(u2);
	
				ses.merge(u);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeFollowers(Users u, Users u2) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			if(u == u2) {
				tx.rollback(); 
				return false;
			} else {
				u.getFollowers().remove(u2);
	
				ses.merge(u);
				tx.commit();
				
				return true;
			}
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Users> findAll() {
		Session ses = HibernateUtil.getSession();
		String hql = "FROM Users";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		List<Users> all = query.list();
		
		if(all.isEmpty()) {
			return null;
		}else {
			return all;
		}
	}

	@Override
	public Users findById(int id) {
		Session ses = HibernateUtil.getSession();
		Users u = ses.get(Users.class, id);
		
		if(u != null) {
			return u;
		}else {
			return null;
		}
	}

	//FIND WHO YOU'RE FOLLOWING
	@Override
	public List<Users> findFollowers(int id){
		Session ses = HibernateUtil.getSession();

		String hql = "SELECT follow FROM Users u JOIN u.followers follow WHERE u.id = :u";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql).setParameter("u", id);
		List<Users> all = query.list();

		if(all.isEmpty()) {
			return null;
		} 
		return all;
	}
	
	//FIND WHOSE FOLLOWS YOU
	@Override
	public List<Users> findFollowees(int id){
		Session ses = HibernateUtil.getSession();
		
		String hql = "SELECT follow FROM Users u JOIN u.followees follow WHERE u.id = :u";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql).setParameter("u", id);
		List<Users> all = query.list();

		if(all.isEmpty()) {
			return null;
		} 

		return all;
	}
}
