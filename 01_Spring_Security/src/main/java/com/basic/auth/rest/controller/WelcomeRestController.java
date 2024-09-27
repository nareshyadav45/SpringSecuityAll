package com.basic.auth.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/logincheck")
	public String loginCheck() {
		return "Welcome , You Can Login ";
	}

	@GetMapping("/contact")
	public String contact() {
		return "call us : 983987129389";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "hi, welcome ";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hi, hello ";
	}
}


