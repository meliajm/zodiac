package com.revature;

import java.util.Date;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		IUserDAO uDao = new UserDAO(); 
		User u = new User();
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setDateOfBirth(new Date());
		u.setUsername("johndoe1");
		u.setPassword(1216985755);
		u.setGender(1);
		//uDao.insert(u);

	}

}
