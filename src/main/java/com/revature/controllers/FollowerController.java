package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Users;
import com.revature.daoimpl.IUserDAO;

@Controller
@RequestMapping(value="/follower")
@ResponseBody
@CrossOrigin(origins="*", allowedHeaders="*")
public class FollowerController {
	
	private IUserDAO us;
	
	@Autowired
	public FollowerController(IUserDAO us) {
		this.us = us; 
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Users>> getFollowers(@PathVariable("id") int id){
		List<Users> users = us.findFollowers(id);
		
		if(users==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
	}
			
	@PutMapping("/add/{id}")
	public ResponseEntity<Users> addFollower(@PathVariable("id") int id, @RequestBody int id2){
		Users user = us.addFollowers(id, id2);
		if(user==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
	@PutMapping("/remove/{id}")
	public ResponseEntity<Users> removeFollower(@PathVariable("id") int id, @RequestBody int id2){
		Users user = us.removeFollowers(id, id2);
		if(user==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

}
