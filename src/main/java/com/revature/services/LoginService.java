//package com.revature.services;
//
//import com.revature.daoimpl.IUserDAO;
//import com.revature.daos.UserDAO;
//import com.revature.models.LoginDTO;
//import com.revature.models.Users;
//
//public class LoginService {
//
//	private static IUserDAO uDao = new UserDAO();
//	
//	public boolean login(LoginDTO l) {
//		Users u = uDao.findByUsername(l.username);
//		System.out.println("user: "+u);
//		if (l.username.equals(u.getUsername()) && l.password.hashCode()==(u.getPassword())) {
//			return true;
//		}
//		return false;
//	}
//}
