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
	public void insert() {
//		Users u = new Users("JohnDoe", 1216985755, "John", "Doe", new Date(), "", 1, null);
//		Users u2 = new Users("JohnnyDoe", 1216985755, "Johnny", "Doe", new Date(), "", 1, null);
//		boolean insert = uDao.insert(u);
//		boolean insert2 = uDao.insert(u2);
//		assertFalse(insert);
//		assertTrue(insert2);
	}
	
	@Test
	public void update() {
		System.out.println("UPDATE:");
		Users u = new Users(5, "DanielWilliam", 1216985755, "Daniel", "Williams", new Date(), "", 1, null);
		
		boolean update = uDao.update(u);
		assertTrue(update);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		Users u = uDao.findById(2);
		Users u2 = uDao.findById(3);
		
		boolean add = uDao.addFollowers(u, u2);
		assertTrue(add);
		boolean add2 = uDao.addFollowers(u, u);
		assertFalse(add2);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		Users u = uDao.findById(3);
		Users u2 = uDao.findById(4);
		
		boolean remove = uDao.removeFollowers(u, u2);
		assertTrue(remove);
		boolean remove2 = uDao.removeFollowers(u2, u2);
		assertTrue(remove2);
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
