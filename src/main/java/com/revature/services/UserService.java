package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

@Service("userService")
public class UserService {
	
	@Autowired
	public static IUserDAO uDao = new UserDAO();

	public Users insert(Users u) {
		return uDao.insert(u);
	}
	
	public Users update(Users u) {
		return uDao.update(u);
	}
	
	public Users addFollowers(int id, Users u) {
		return uDao.addFollowers(id, u);
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
