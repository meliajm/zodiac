package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

@Repository("userDAO")
public class UserDAO implements IUserDAO{

	@Override
	public Users insert(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			ses.save(u);
			
			tx.commit();
			
			return u;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Users update(Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			ses.merge(u);

			tx.commit();
			return u;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			System.out.println(e);
			return null;
		}

	}
	
	@Override
	public Users addFollowers(int id, Users u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();
			
			Users user = findById(id);
			if(user == u) {
				tx.rollback();
				return null;
			} else {
				user.getFollowers().add(u);
	
				ses.merge(user);
				tx.commit();
				return user;
			}
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			System.out.println(e);
			return null;
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
			System.out.println(e);
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
	
	@Override
	public Users findByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		String hql = "FROM User u WHERE u.username = :u";
		
		Query<Users> query = ses.createQuery(hql, Users.class).setParameter("u", username);
		Users u = query.list().get(0);
		
		return u;
	}
}
