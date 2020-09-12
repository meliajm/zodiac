package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.UserService;

public class UserController {
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getUser(HttpServletResponse res, int id) throws IOException {
		Users u = us.findById(id);
		
		if(u == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
	
	public void getFollowers(HttpServletResponse res, int id) throws IOException {
		List<Users> u = us.findFollowers(id);
		
		if(u == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
	
	public void getFollowees(HttpServletResponse res, int id) throws IOException {
		List<Users> u = us.findFollowees(id);
		
		if(u == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
	
	public void getAll(HttpServletResponse res) throws IOException {
		List<Users> all = us.findAll();
		
		if(all.isEmpty()) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			
			String json = om.writeValueAsString(all);
			res.getWriter().println(json);
		}
	}
	
	public void addUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Users u = om.readValue(body, Users.class);
		
		if (us.insert(u)) {
			res.setStatus(201);
		} else {
			res.setStatus(403);
		}
	}
	
	public void updateUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Users u = om.readValue(body, Users.class);
		
		if(us.update(u)) {
			res.setStatus(200);
		} else {
			res.setStatus(403);
		}
	}
	
	public void addFollower(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Users u = om.readValue(body, Users.class);
		
		Users u2 = om.readValue(body, Users.class);
		
		if(us.addFollowers(u, u2)) {
			res.setStatus(200);
		} else {
			res.setStatus(403);
		}
	}
	
	public void removeFollower(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		Users u = om.readValue(body, Users.class);
		
		Users u2 = om.readValue(body, Users.class);
		
		if(us.removeFollowers(u, u2)) {
			res.setStatus(200);
		} else {
			res.setStatus(403);
		}
	}

}
