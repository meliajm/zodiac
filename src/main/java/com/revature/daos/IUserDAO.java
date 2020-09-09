package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {

	public boolean insert(User u);
	
	public boolean update(User u);
	
	public boolean delete(int id);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByUsername(String username);
	
	public List<User> findFollowers(User u);
	
	public List<User> findFollowees(User u);
}
