package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAO implements IUserDAO {

	public UserDAO() {
		super();
	}

	@Override
	public boolean insert(User u) {
		Session ses = HibernateUtil.getSession();

			Transaction tx = ses.beginTransaction();
			
			ses.save(u);
			tx.commit();
			return true;

	}

	@Override
	public boolean update(User u) {
		Session ses = HibernateUtil.getSession();
		try {
			Transaction tx = ses.beginTransaction();
			
			ses.merge(u);
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		Session ses = HibernateUtil.getSession();
		return false;
	}

	@Override
	public List<User> findAll() {
		Session ses = HibernateUtil.getSession();
		List<User> all = ses.createQuery("FROM User", User.class).list();
		return all;
	}

	@Override
	public User findById(int id) {
		Session ses = HibernateUtil.getSession();
		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public User findByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> u = (List<User>)ses.createQuery("FROM User u WHERE u.username = '" + username + "' ", User.class).list();
		return (User) u;
	}

	@Override
	public List<User> findFollowers(User u) {
		Session ses = HibernateUtil.getSession();
		List<User> all = (List<User>)ses.createNativeQuery("SELECT * FROM users u JOIN user_follower f ON u.userid = " + u.getUserid(), User.class).list();
		return all;
	}

	@Override
	public List<User> findFollowees(User u) {
		Session ses = HibernateUtil.getSession();
		List<User> all = (List<User>)ses.createNativeQuery("SELECT * FROM users u JOIN user_follower f ON u.userid=" + u.getFollowerid(), User.class).list();
		return all;
	}

}
