package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController{
	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginDTO l = new LoginDTO();
		l.username = username;
		l.password = password;
		
		if (req.getMethod().equals("POST")) {
	
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while (line != null) {
				sb.append(line);
				line=reader.readLine();
			}
			
			String body = new String(sb);
			System.out.println("body: "+ body);
			l = om.readValue(body, LoginDTO.class);
			System.out.println("ls.login(l): "+ ls.login(l));
	
			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				System.out.println("you logged in, success!");
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
	
			} else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed");
			}
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);
		if (ses !=null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user"); 
			ses.invalidate();		
			res.setStatus(200);
			res.getWriter().println(l.username + " has logged out successfully.");
					
		}  else {
			res.setStatus(400);
			res.getWriter().println("you must be logged in to log out");
		}
	}
}
