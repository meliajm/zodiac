package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class ServiceTest {
	IUserDAO uDao = new UserDAO();
	
	@Before
	public void before() {System.out.println("\n Test:");}
	
	
	@Test
	public void update() {
		System.out.println("UPDATE:");
//		Users u = new Users(5, "DanielSmith", 1216985755, "Daniel", "Smith", new Date(), "", 1, null);
//		
//		boolean update = uDao.update(u);
//		assertTrue(update);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		boolean add = uDao.addFollowers(1, 2);
		boolean add2 = uDao.addFollowers(1, 1);
		List<Users> user1 = uDao.findFollowers(1);
		for(Users u: user1) {System.out.println("Add: "+u);}
		assertTrue(add);
		assertFalse(add);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		boolean remove = uDao.removeFollowers(1, 2);
		boolean remove2 = uDao.removeFollowers(1, 1);
		assertTrue(remove);
		assertFalse(remove2);
	}
	
	@Test
	public void follower() {
		List<Users> user1 = uDao.findFollowers(1);
		assertNotNull(user1);
		
		List<Users> user2 = uDao.findFollowers(4);
		assertNull(user2);
	}
	
	@Test
	public void followee() {
		List<Users> user1 = uDao.findFollowees(4);
		assertNotNull(user1);
		
		List<Users> user2 = uDao.findFollowees(1);
		assertNull(user2);
	}

	@Test
	public void select() {
		Users u1 = uDao.findById(5);
		assertNotNull(u1);
		
		Users u2 = uDao.findById(25);
		assertNull(u2);
		
		List<Users> user = uDao.findAll();
		assertNotNull(user);
	}
	


}
