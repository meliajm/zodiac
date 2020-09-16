package com.revature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

public class ServiceTest {
	IUserDAO uDao;
	
	@Before
	public void before() {System.out.println("\n Test:");}
	
	@Test
	public void insert() {
		Users u = new Users("JohnDoe", 1216985755, "John", "Doe", new Date(), "", 1, null);
//		Users u2 = new Users("JaneDoe", 1216985755, "Jane", "Doe", new Date(), "", 2, null);
//		Users u3 = new Users("JillSmith", 1216985755, "Jill", "Smith", new Date(), "", 2, null);
//		Users u4 = new Users("JoeSmith", 1216985755, "Joe", "Smith", new Date(), "", 1, null);
//		Users u5 = new Users("DanSmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
		Users insert1 = uDao.insert(u);
		//uDao.insert(u2);uDao.insert(u3);uDao.insert(u4);uDao.insert(u5);
		assertNull(insert1);
	}
	
	@Test
	public void update() {
		System.out.println("UPDATE:");
		Users u = new Users(5, "DanielWilliam", 1216985755, "Daniel", "Williams", new Date(), "", 1, null);
		Users u2 = new Users("DanielWilliam", 1216985755, "Daniel", "Williams", new Date(), "", 1, null);
		
		Users update = uDao.update(u);
		assertNotNull(update);
		Users update2 = uDao.update(u2);
		assertNull(update2);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		Users u = uDao.findById(1);
		Users u2 = uDao.findById(2);

		Users add = uDao.addFollowers(1, u2);
		assertNotNull(add);
		Users add2 = uDao.addFollowers(1, u);
		assertNull(add2);
		Users add3 = uDao.addFollowers(5, u);
		assertNull(add3);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		Users u = uDao.findById(1);
		Users u2 = uDao.findById(2);
		
		Users remove = uDao.removeFollowers(1, u2);
		assertNotNull(remove);
		Users remove2 = uDao.removeFollowers(2, u2);
		assertNull(remove2);
		Users add3 = uDao.removeFollowers(3, u);
		assertNull(add3);
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
		assertNull(user1);
		
		List<Users> user2 = uDao.findFollowees(1);
		assertNotNull(user2);
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
