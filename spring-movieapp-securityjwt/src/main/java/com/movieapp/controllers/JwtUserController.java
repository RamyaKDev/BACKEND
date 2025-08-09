package com.movieapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.model.JwtUserRequest;
import com.movieapp.service.JwtUserServiceImpl;
import com.movieapp.util.JwtTokenUtil;



@RestController
@RequestMapping("/user-api/v1")
public class JwtUserController {
	
	@Autowired
	private JwtUserServiceImpl userServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	//http://localhost:8081/user-api/v1/register
	//first time user
	@PostMapping("/register")
	public ResponseEntity<Void> createUser(@RequestBody JwtUserRequest userRequest) {
		//Get pwd from userRequest
		String password=userRequest.getPassword();
		//encode the password using password Encoder
		String newpassword=passwordEncoder.encode(password);
		//attaching newpassword to userRequest
		userRequest.setPassword(newpassword);
		
		//call the service layer method to save the apiuser object
		userServiceImpl.createUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//user logging in and getting the token
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody JwtUserRequest userRequest){
		// get the username
		String username = userRequest.getUsername();
		// check if the name is available in the db
		UserDetails userdetails =  userServiceImpl.loadUserByUsername(username);
		String token = jwtTokenUtil.generateToken(userdetails);
		return ResponseEntity.ok(token);
	}

	
}
