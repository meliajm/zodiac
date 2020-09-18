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

//	@Test
//	public void insert() {
//	//username, password, firstName, lastName, dateOfBirth, description, gender, picture
//	Users u = new Users("JohnDoe", "johnny", "John", "Doe", new Date(), "", 1, null);
//	Users u2 = new Users("JaneDoe", "deer", "Jane", "Doe", new Date(), "", 2, null);
//	Users u3 = new Users("JillSmith", "willynilly", "Jill", "Smith", new Date(), "", 2, null);
//	Users u4 = new Users("JoeSmith", "sloppy", "Joe", "Smith", new Date(), "", 1, null);
//	Users u5 = new Users("DanSmith", "theman", "Dan", "Smith", new Date(), "", 1, null);
//	//Insert
//	dao.insert(u);dao.insert(u2);dao.insert(u3);dao.insert(u4);dao.insert(u5);
//	System.out.println("INSERT");
//	List<Users> all = dao.findAll();
//	for(Users user: all) {System.out.println(user);}
//	}
	
	@Test
	public void update() {
		System.out.println("UPDATE:");
		Users u = new Users(5, "DanielleSmith", "thewoman", "Danielle", "Smith", new Date(), "", 1, null);
		System.out.println(dao.findById(5));
		Users update = dao.update(u);
		System.out.println(u);
		assertNotNull(update);
	}
	
	@Test
	public void add() {
		System.out.println("ADD:");
		dao.addFollowers(5, 1);
		dao.addFollowers(5, 2);
		dao.addFollowers(5, 3);
		
		Users add = dao.addFollowers(1, 2);
		System.out.println("Added Follower:"+add);
		assertNotNull(add);
	}
	
	@Test
	public void remove() {
		System.out.println("REMOVE:");
		Users remove = dao.removeFollowers(1, 2);
		System.out.println("Removed Follower:"+remove);
		assertNotNull(remove);
	}
	
	@Test
	public void follower() {
		System.out.println("FOLLOWING:");
		List<Users> user1 = dao.findFollowers(1);
		System.out.println(user1);
		assertNotNull(user1);
	}
	
	@Test
	public void followee() {
		System.out.println("FOLLOWED BY:");
		List<Users> user1 = dao.findFollowees(2);
		System.out.println(user1);
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
		System.out.println(ul);
		assertNotNull(ul);
	}


}
