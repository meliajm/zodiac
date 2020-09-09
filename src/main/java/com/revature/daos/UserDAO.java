package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public class UserDAO implements IUserDAO {

	public UserDAO() {
		super();
	}

	@Override
	public boolean insert(User u) {
		
		return false;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findFollowers(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findFollowees(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
