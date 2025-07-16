package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	@GetMapping("/greet")
	public String greetMessage(ModelMap map) {
		//call the methods of service layer
		//this is the data requested by the client
		String message="Have a great day";
		//attach the data to the model and give a dummy name
		map.addAttribute("mymessage",message);
		
		return "success";//view page name
	}
	
	@GetMapping("/say_hello")
	public String helloMessage(Model model) {
		//call the methods of service layer
		//this is the data requested by the client
		String message="Hello ";
		//attach the data to the model and give a dummy name
		model.addAttribute("mymessage",message);		
		return "success";//view page name
	}
	
	@GetMapping("/welcome")
	public ModelAndView welcomeMessage() {
		//call the methods of service layer
		//this is the data requested by the client
		//create a modelview which has both
		ModelAndView modelandview=new ModelAndView("success","message","welcome to MVC");
		return modelandview;
	}
}
