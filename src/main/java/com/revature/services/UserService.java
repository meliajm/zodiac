package com.revature.services;

import java.util.List;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class UserService {
	
	public static IUserDAO uDao = new UserDAO();

	public boolean insert(Users u) {
		return uDao.insert(u);
	}
	
	public boolean update(Users u) {
		return uDao.update(u);
	}
	
	public boolean addFollowers(Users u, Users u2) {
		return uDao.addFollowers(u, u2);
	}
	
	public boolean removeFollowers(Users u, Users u2) {
		return uDao.removeFollowers(u, u2);
	}
	
	public Users findById(int id) {
		return uDao.findById(id);
	}
	
	public List<Users> findFollowers(int id){
		return uDao.findFollowers(id);
	}
	
	public List<Users> findFollowees(int id){
		return uDao.findFollowees(id);
	}
	
	public List<Users> findAll(){
		return uDao.findAll();
	}
}
