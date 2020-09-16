package com.revature;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserDAO dao = ac.getBean(IUserDAO.class);
		
		System.out.println("\n Find All");
		List<Users> users = dao.findAll();
		for(Users u : users){System.out.println(u);}
		
		//username, password, firstName, lastName, dateOfBirth, description, gender, picture
		Users u = new Users("JohnWolfe", 1216985755, "John", "Wolfe", new Date(), "", 1, null);
//		Users u2 = new Users("JaneDoe", 1216985755, "Jane", "Doe", new Date(), "", 2, null);
//		Users u3 = new Users("JillSmith", 1216985755, "Jill", "Smith", new Date(), "", 2, null);
//		Users u4 = new Users("JoeSmith", 1216985755, "Joe", "Smith", new Date(), "", 1, null);
//		Users u5 = new Users("DanSmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
//		
//		//Insert
//		uDao.insert(u);uDao.insert(u2);uDao.insert(u3);uDao.insert(u4);uDao.insert(u5);
//		System.out.println("\n Inser User");
//		dao.insert(u);
//		System.out.println(u);
		
		//Update
//		System.out.println("\n Update");
//		Users up5 = new Users(5, "DanielleSmith", 1216985755, "Danielle", "Smith", new Date(), "", 2, null);
//		dao.update(up5);
//		
		//Find By ID
//		System.out.println("\n Find By ID");
//		Users u1 = dao.findById(5);
//		System.out.println(u1);
		
		//Add Followers
		System.out.println("\n Add Followers");
		Users u1 = dao.findById(43);
		Users u2 = dao.findById(42);

		dao.addFollowers(1, u1);
		System.out.println("\n Remove Followers");
		dao.removeFollowers(1, u2);
//		
//		System.out.println("\n Find All");
//		List<Users> user = dao.findAll();
//		for(Users us : user) {System.out.println(us);}
//		
		System.out.println("\n Following");
		List<Users> user2 = dao.findFollowers(1);
		for(Users us : user2) {System.out.println(us);}
		
		System.out.println("\n FollowBy");
		List<Users> user3 = dao.findFollowees(2);
		for(Users us : user3) {System.out.println(us);}

	}

}
