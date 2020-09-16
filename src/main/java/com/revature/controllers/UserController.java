package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Users;
import com.revature.services.UserService;

@Controller("userController")
@RequestMapping(value="/user")
@ResponseBody
public class UserController {
	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us = us; 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Users> getAll(){
		return us.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUser(@PathVariable("id") int id){
		Users u = us.findById(id);
		
		if(u==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);	
	}
	
	@GetMapping("/followers/{id}")
	public ResponseEntity<List<Users>> getFollowers(@PathVariable("id") int id){
		List<Users> users = us.findFollowers(id);
		
		if(users==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
	}
		
	@GetMapping("/followees/{id}")
	public ResponseEntity<List<Users>> getFollowees(@PathVariable("id") int id){
		List<Users> users = us.findFollowees(id);
		
		if(users==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
	}
	
	@PostMapping
	public ResponseEntity<Users> addUser(@RequestBody Users u){
		u = us.insert(u);
		
		if(u==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
	@PutMapping
	public ResponseEntity<Users> update(@RequestBody Users u){
		u = us.update(u);
		if(u==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
	}
	
	@PutMapping("/followers/{id}")
	public ResponseEntity<Users> addFollower(@PathVariable("id") int id, @RequestBody Users u){
		Users user = us.addFollowers(id, u);
		if(user==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
//	@PutMapping
//	public void removeFollower(){}
//
//	@PostMapping
//	public void login() {}
//	
//	@GetMapping
//	public void logout() {}
}
