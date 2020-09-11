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
		Users u = new Users("JohnDoe", 1216985755, "John", "Doe", new Date(), "", 1, null);
//		Users u2 = new Users("JaneDoe", 1216985755, "Jane", "Doe", new Date(), "", 2, null);
//		Users u3 = new Users("JillSmith", 1216985755, "Jill", "Smith", new Date(), "", 2, null);
//		Users u4 = new Users("JoeSmith", 1216985755, "Joe", "Smith", new Date(), "", 1, null);
//		Users u5 = new Users("DanSmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
		boolean insert1 = uDao.insert(u);
		//uDao.insert(u2);uDao.insert(u3);uDao.insert(u4);uDao.insert(u5);
		assertFalse(insert1);
	}
	
	@Test
	public void update() {
		System.out.println("UPDATE:");
		Users u = new Users(5, "DanielWilliam", 1216985755, "Daniel", "Williams", new Date(), "", 1, null);
		Users u2 = new Users("DanielWilliam", 1216985755, "Daniel", "Williams", new Date(), "", 1, null);
		
		boolean update = uDao.update(u);
		assertTrue(update);
		boolean update2 = uDao.update(u2);
		assertFalse(update2);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		Users u = uDao.findById(1);
		Users u2 = uDao.findById(2);
		Users u3 = uDao.findById(3);
		Users u4 = uDao.findById(4);
		Users u5 = uDao.findById(5);
		
		uDao.addFollowers(u, u3);
		uDao.addFollowers(u, u4);
		uDao.addFollowers(u3, u2);
		uDao.addFollowers(u3, u4);
		
		boolean add = uDao.addFollowers(u, u2);
		assertTrue(add);
		boolean add2 = uDao.addFollowers(u, u);
		assertFalse(add2);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		Users u = uDao.findById(1);
		Users u2 = uDao.findById(2);
		
		boolean remove = uDao.removeFollowers(u, u2);
		assertTrue(remove);
		boolean remove2 = uDao.removeFollowers(u2, u2);
		assertFalse(remove2);
	}
	
	@Test
	public void follower() {
		System.out.println("FOLLOWING:");
		List<Users> user1 = uDao.findFollowers(1);
		assertNotNull(user1);
		
		List<Users> user2 = uDao.findFollowers(4);
		assertNull(user2);
	}
	
	@Test
	public void followee() {
		System.out.println("FOLLOWED BY:");
		List<Users> user1 = uDao.findFollowees(4);
		assertNotNull(user1);
		
		List<Users> user2 = uDao.findFollowees(1);
		assertNull(user2);
	}

	@Test
	public void select() {
		System.out.println("SELECT:");
		Users u1 = uDao.findById(5);
		assertNotNull(u1);
		
		Users u2 = uDao.findById(25);
		assertNull(u2);
		
		List<Users> user = uDao.findAll();
		assertNotNull(user);
	}
	


}
