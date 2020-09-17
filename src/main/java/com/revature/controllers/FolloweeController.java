package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

@Controller
@RequestMapping(value="/followee")
@ResponseBody
@CrossOrigin(origins="*", allowedHeaders="*")
public class FolloweeController {
		
	private IUserDAO us;
	
	@Autowired
	public FolloweeController(IUserDAO us) {
		this.us = us; 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Users>> getFollowees(@PathVariable("id") int id){
		List<Users> users = us.findFollowees(id);
		
		if(users==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
	}
}
