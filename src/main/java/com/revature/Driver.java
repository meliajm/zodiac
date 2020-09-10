package com.revature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class Driver {

	public static void main(String[] args) {
		IUserDAO uDao = new UserDAO();

		
		//username, password, firstName, lastName, dateOfBirth, description, gender, picture
		Users u = new Users("JohnDoe", 1216985755, "John", "Doe", new Date(), "", 1, null);
		Users u2 = new Users("JaneDoe", 1216985755, "Jane", "Doe", new Date(), "", 2, null);
		Users u3 = new Users("JillSmith", 1216985755, "Jill", "Smith", new Date(), "", 2, null);
		Users u4 = new Users("JoeSmith", 1216985755, "Joe", "Smith", new Date(), "", 1, null);
		Users u5 = new Users("DanSmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
		
		//Insert
		uDao.insert(u);uDao.insert(u2);uDao.insert(u3);uDao.insert(u4);uDao.insert(u5);
		
		//Find All 
		System.out.println("\n Find All");
		List<Users> user = uDao.findAll();
		for(Users us : user) {System.out.println(us);}
		
		//Update
		System.out.println("\n Update");
		Users up5 = new Users(5, "DannySmith", 1216985755, "Dan", "Smith", new Date(), "", 1, null);
		uDao.update(up5);
		
		//Find By ID
		System.out.println("\n Find By ID");
		Users u1 = uDao.findById(5);
		System.out.println(u1);
		
		//Add Followers
		System.out.println("\n Add Followers");
		List<Users> followers = new ArrayList<Users>();
		followers.add(u2);
		followers.add(u4);
		
		Users f1 = new Users(1, followers);
		uDao.update(f1);
		
		System.out.println("Select by id:" + u);
	}

}
