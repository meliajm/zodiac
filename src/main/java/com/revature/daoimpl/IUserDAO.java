package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Users;

public interface IUserDAO {

	public Users insert(Users u);
	
	public Users update(Users u);
	
	public Users addFollowers(int id, Users u);
	
	public Users removeFollowers(int id, Users u);
	
	public Users findById(int id);
	
	public Users findByLogin(String username, String password);
	
	public List<Users> findFollowers(int id);
	
	public List<Users> findFollowees(int id);
	
	public List<Users> findAll();
	
}
