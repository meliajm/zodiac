package com.revature;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.UserController;
import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class Driver {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		  UserController controller = (UserController) context.getBean("userController");
		  ResponseEntity<Users> u = controller.getUser(1);
		  System.out.println("Country Name : " + u);
		  List<Users> u2 = controller.getAll();
		  for(Users user : u2) {System.out.println(user);}
		

		
		//username, password, firstName, lastName, dateOfBirth, description, gender, picture
//		Users u = new Users("JohnDoe", 1216985755, "John", "Doe", new Date(), "", 1, null);
//		Users u2 = new Users("JaneDoe", 1216985755, "Jane", "Doe", new Date(), "", 2, null);
//		Users u3 = new Users("JillSmith", 1216985755, "Jill", "Smith", new Date(), "", 2, null);
//		Users u4 = new Users("JoeSmith", 1216985755, "Joe", "Smith", new Date(), "", 1, null);
//		Users u5 = new Users("DanSmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
//		
//		//Insert
//		uDao.insert(u);uDao.insert(u2);uDao.insert(u3);uDao.insert(u4);uDao.insert(u5);
		
		//Update
//		System.out.println("\n Update");
//		Users up5 = new Users(5, "DanielSmith", 1216985755, "Daniel", "Smith", new Date(), "", 1, null);
//		uDao.update(up5);
//		
//		//Find By ID
//		System.out.println("\n Find By ID");
//		Users u1 = uDao.findById(5);
//		System.out.println(u1);
		
		//Add Followers
//		System.out.println("\n Add Followers");
//		Users u = uDao.findById(1);
//		Users u2 = uDao.findById(2);
//		Users u3 = uDao.findById(3);
//		Users u5 = uDao.findById(5);
//		uDao.addFollowers(u, u2);
//		uDao.addFollowers(u, u5);
//		uDao.removeFollowers(u, u3);
//		
//		System.out.println("\n Find All");
//		List<Users> user = uDao.findAll();
//		for(Users us : user) {System.out.println(us);}
//		
//		System.out.println("\n Following");
//		List<Users> user2 = uDao.findFollowers(3);
//		for(Users us : user2) {System.out.println(us);}
//		
//		System.out.println("\n FollowBy");
//		List<Users> user3 = uDao.findFollowees(3);
//		for(Users us : user3) {System.out.println(us);}

	}

}
