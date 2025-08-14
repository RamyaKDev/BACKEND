package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {
 @GetMapping("/say-hello/{username}")
	public ResponseEntity<String> sayHello(@PathVariable String username){
	 String message="Hello"+username;
	 return ResponseEntity.ok(message);
 }
}
