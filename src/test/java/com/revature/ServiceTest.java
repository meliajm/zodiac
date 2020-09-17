package com.revature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

public class ServiceTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	IUserDAO dao = ac.getBean(IUserDAO.class);
	
	@Before
	public void before() {System.out.println("\n Test:");}

	
	@Test
	public void update() {
		System.out.println("UPDATE:");
		Users u = new Users(5, "DanielWilliam", "theman", "Daniel", "Williams", new Date(), "", 1, null);
		
		Users update = dao.update(u);
		assertNotNull(update);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		Users add = dao.addFollowers(2, 1);
		assertNotNull(add);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		Users remove = dao.removeFollowers(2, 1);
		assertNotNull(remove);
	}
	
	@Test
	public void follower() {
		System.out.println("FOLLOWING:");
		List<Users> user1 = dao.findFollowers(1);
		assertNotNull(user1);
	}
	
	@Test
	public void followee() {
		System.out.println("FOLLOWED BY:");
		List<Users> user1 = dao.findFollowees(2);
		assertNotNull(user1);
	}

	@Test
	public void select() {
		System.out.println("SELECT:");
		Users u1 = dao.findById(5);
		System.out.println(u1);
		assertNotNull(u1);
		
		Users u2 = dao.findById(25);
		System.out.println(u2);
		assertNull(u2);
		
		List<Users> user = dao.findAll();
		System.out.println(user);
		assertNotNull(user);
	}
	
	@Test
	public void login() {
		System.out.println("LOGIN:");
		Users ul = dao.findByLogin("JaneDoe", "deer");
		assertNotNull(ul);
	}


}
