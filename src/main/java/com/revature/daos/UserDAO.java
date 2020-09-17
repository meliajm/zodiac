package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

@Repository
@Transactional
public class UserDAO implements IUserDAO{

	private SessionFactory sf;
	
	@Autowired
	public UserDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public Users insert(Users u) {
		Session ses = sf.getCurrentSession();
		StringBuilder sb = new StringBuilder();
		int pass = u.getPassword().hashCode();
		sb.append(pass);
		
		String hashpass = sb.toString();
		u.setPassword(hashpass);
		ses.save(u);
		return u;
	}

	@Override
	public Users update(Users u) {
		Session ses = sf.getCurrentSession();
		StringBuilder sb = new StringBuilder();
		int pass = u.getPassword().hashCode();
		sb.append(pass);
		
		String hashpass = sb.toString();
		u.setPassword(hashpass);
		ses.merge(u);
		return u;
	}
	
	@Override
	public Users addFollowers(int id, Users u) {
		Session ses = sf.getCurrentSession();
		Users user = findById(id);
		
		user.getFollowers().add(u);
		ses.merge(user);
		
		return user;
	}
	
	@Override
	public Users removeFollowers(int id, Users u) {
		Session ses = sf.getCurrentSession();
		Users user = findById(id);	
		
		user.getFollowers().remove(u);
		ses.merge(u);
		
		return user;
	}
	
	@Override
	public List<Users> findAll() {
		Session ses = sf.getCurrentSession();
		String hql = "FROM Users";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql);
		List<Users> all = query.list();
		
		return all;
	}

	@Override
	public Users findById(int id) {
		Session ses = sf.getCurrentSession();
		return ses.get(Users.class, id);
	}

	//FIND WHO YOU'RE FOLLOWING
	@Override
	public List<Users> findFollowers(int id){
		Session ses = sf.getCurrentSession();
		String hql = "SELECT follow FROM Users u JOIN u.followers follow WHERE u.id = :u";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql).setParameter("u", id);
		List<Users> all = query.list();
		
		return all;
	}
	
	//FIND WHOSE FOLLOWS YOU
	@Override
	public List<Users> findFollowees(int id){
		Session ses = sf.getCurrentSession();
		String hql = "SELECT follow FROM Users u JOIN u.followees follow WHERE u.id = :u";
		
		@SuppressWarnings("unchecked")
		Query<Users> query = ses.createQuery(hql).setParameter("u", id);
		List<Users> all = query.list();
		
		return all;
	}
	
	@Override
	public Users findByLogin(String username, String password) {
		Session ses = sf.getCurrentSession();
		String hql = "FROM Users u WHERE u.username = :u AND u.password = :p";
		StringBuilder sb = new StringBuilder();
		int pass = password.hashCode();
		sb.append(pass);
		
		String hashpass = sb.toString();

		Query<Users> query = ses.createQuery(hql, Users.class).setParameter("u", username).setParameter("p", hashpass);
		Users u = query.list().get(0);
		
		return u;
	}
	
}
