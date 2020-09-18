package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daoimpl.IUserDAO;
import com.revature.models.Users;

@Controller
@RequestMapping(value="/login")
@ResponseBody
@CrossOrigin(origins="*", allowedHeaders="*")
public class LoginController {
	
	private IUserDAO us;
	
	@Autowired
	public LoginController(IUserDAO us) {
		this.us = us;
	}
	
	@PostMapping
	public ResponseEntity<Users> login(@RequestBody Users u, HttpSession ses){
		Users user = us.findByLogin(u.getUsername(), u.getPassword());
		
		if(user==null) {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
		ses.setAttribute("user", user);
		ses.setAttribute("loggedin", true);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
	@GetMapping
	public void logout(HttpSession ses) {
		ses.removeAttribute("user");
	}

}
