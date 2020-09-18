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
		
		System.out.println("LOGIN:");
		Users ul = dao.findByLogin("JaneDoe", "deer");
		System.out.println(ul);
		
//		System.out.println("\n Find All");
//		List<Users> users = dao.findAll();
//		for(Users u : users){System.out.println(u);}
//		
//		//username, password, firstName, lastName, dateOfBirth, description, gender, picture
//		Users u = new Users("JohnDoe", "johnny", "John", "Doe", new Date(), "", 1, null);
//		Users u2 = new Users("JaneDoe", "deer", "Jane", "Doe", new Date(), "", 2, null);
//		Users u3 = new Users("JillSmith", "willynilly", "Jill", "Smith", new Date(), "", 2, null);
//		Users u4 = new Users("JoeSmith", "sloppy", "Joe", "Smith", new Date(), "", 1, null);
//		Users u5 = new Users("DanSmith", "theman", "Dan", "Smith", new Date(), "", 1, null);
		//Insert
//		dao.insert(u);dao.insert(u2);dao.insert(u3);dao.insert(u4);dao.insert(u5);
//		System.out.println("\n Insert User");
//		System.out.println(u);

	}

}
