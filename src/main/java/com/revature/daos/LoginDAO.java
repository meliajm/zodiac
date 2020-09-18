//package com.revature.daos;
//
//import com.revature.daoimpl.IUserDAO;
//import com.revature.models.LoginDTO;
//import com.revature.models.Users;
//
//public class LoginDAO {
//	//private static final Logger log = LogManager.getLogger(LoginService.class);
//
//	IUserDAO dao;
//
//	public boolean login(LoginDTO l) {
//		Users u = dao.findByLogin(l.username, l.password);
//		if(u == null) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//}
