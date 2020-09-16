package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Users;

public interface IUserDAO {

	public Users insert(Users u);
	
	public Users update(Users u);
	
	public Users addFollowers(int id, Users u);
	
	public boolean removeFollowers(Users u, Users u2);
	
	public Users findById(int id);
	
	public Users findByUsername(String username);
	
	public List<Users> findFollowers(int id);
	
	public List<Users> findFollowees(int id);
	
	public List<Users> findAll();
	
}
