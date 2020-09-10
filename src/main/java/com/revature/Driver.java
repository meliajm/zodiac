package com.revature;

import java.util.Date;
import java.util.List;

import com.revature.daoimpl.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class Driver {

	public static void main(String[] args) {
		IUserDAO uDao = new UserDAO(); //String username, int password, String firstName, String lastName,Date dateOfBirth, String description, int gender, byte[] picture
		Users u = new Users("JillSmith1", 1216985755, "John", "Doe", new Date(), "", 1, null);
//		u.setFirstName("John");
//		u.setLastName("Doe");
//		u.setDateOfBirth(new Date());
//		u.setUsername("johndoe1");
//		u.setPassword(1216985755);
//		u.setGender(1);
		uDao.insert(u);
		List<Users> user = uDao.findAll();
		for(Users us : user) {System.out.println(us);}
		Users u1 = uDao.findById(1);
		System.out.println("Select by id:" + u1);
	}

}
