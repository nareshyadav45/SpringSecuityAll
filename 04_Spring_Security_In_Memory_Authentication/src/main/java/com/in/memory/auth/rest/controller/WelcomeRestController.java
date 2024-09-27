package com.in.memory.auth.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/contact")
	public String contact() {
		return "Contact Us : 91 912124712947";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to in memory authentication";
	}

	@GetMapping("/greet")
	public String greet() {
		return "Hi, how are you!!";
	} 
	
}
