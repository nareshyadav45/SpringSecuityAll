package com.security.oauth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/")
	public String hello() {
		return "Hello, Welcome TO OAuth";
	}
	
	
}
