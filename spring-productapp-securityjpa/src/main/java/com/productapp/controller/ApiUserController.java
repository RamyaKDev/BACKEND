package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ApiUserDto;
import com.productapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {
	@Autowired
	private ApiUserServiceImpl userServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//http://localhost:8081/user-api/v1/apiusers
	public ResponseEntity<Void> addUser(@RequestBody ApiUserDto userDto){
		//get the password from the dto object
		String password=userDto.getPassword();
		//encode the password and generate a new one
		String newpassword=passwordEncoder.encode(password);
		//set the new password to the dto object
		userDto.setPassword(newpassword);
		//call the service method to create user
		userServiceImpl.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
