package com.security.user.details.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.user.details.servicee.entity.Users;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private UsersRepository repository;

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

	@PostMapping("/saveuser")
	public Users saveUser(@RequestBody Users users ) {
		return this.repository.save(users);
	}
	
}
