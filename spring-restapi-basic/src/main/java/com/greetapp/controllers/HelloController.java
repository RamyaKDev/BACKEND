package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//controller+responsebody
public class HelloController {

	// http:localhost/8080/hello
	@GetMapping("/hello")
	public String showMessage() {
		// call the methods of service layer
		// return the data directly
		return "Hello user";
	}

	// http:localhost:8080/hello/username/ramya
	@GetMapping("/hello/username/{username}")
	public String greetMessage(@PathVariable String username) {
		// call the methods of service layer
		// return the data directly
		return "Hello " + username;
	}

	// http:localhost:8080/search?hotel=sangeetha
	@GetMapping("/search")
	public List<String> getMenu(@RequestParam("hotel") String hotelname) {
		// call the methods of service layer
		// return the data directly
		return Arrays.asList("Idli", "Dosa", "Pongal");
	}
}
