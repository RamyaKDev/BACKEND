package com.productapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ApiUser;
import com.productapp.model.ApiUserRequest;
import com.productapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {
	
	@Autowired
	private ApiUserServiceImpl userServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/apiusers/register")
	public ResponseEntity<Void> createUser(@RequestBody ApiUserRequest userRequest) {
		//Get pwd from userRequest
		String password=userRequest.getPassword();
		//encode the password using password Encoder
		String newpassword=passwordEncoder.encode(password);
		//attaching newpassword to userRequest
		userRequest.setPassword(newpassword);
		//convert the ApiUserRequest to ApiUser object
		ApiUser apiUser=mapper.map(userRequest,ApiUser.class);
		//call the service layer method to save the apiuser object
		userServiceImpl.createUser(apiUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
