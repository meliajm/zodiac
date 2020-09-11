package com.revature.daoimpl;

import java.util.List;

import com.revature.models.Users;

public interface IUserDAO {
	
	public boolean insert(Users u);
	
	public boolean update(Users u);
	
	public boolean addFollowers(int id, int id2);
	
	public boolean removeFollowers(int id, int id2);
	
	public Users findById(int id);
	
	public List<Users> findFollowers(int id);
	
	public List<Users> findFollowees(int id);
	
	public List<Users> findAll();
	
}
