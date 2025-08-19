package com.greetapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetController {
	@GetMapping("/greet/{username}")
	public String greetMessage(@PathVariable String username ) {
		
		return "Hello"+username;
	}
	
	
}
