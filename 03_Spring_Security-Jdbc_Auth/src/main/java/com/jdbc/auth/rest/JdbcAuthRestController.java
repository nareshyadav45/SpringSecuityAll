package com.jdbc.auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcAuthRestController {

	@GetMapping("/admincheck")
	public String admin() {
		return "Hi, Admin";
	}
	
	@GetMapping("/usercheck")
	public String userCheck() {
		
		return "Hi , User ";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome all";
	}
	
}
