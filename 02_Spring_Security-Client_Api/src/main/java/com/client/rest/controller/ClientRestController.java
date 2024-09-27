package com.client.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	private final static  String SERVICE_URL="http://localhost:8080/welcome";
	
	@GetMapping("/client")
	public String clienRestTmeplate() {
		ResponseEntity<String> forEntity = this.restTemplate.getForEntity(SERVICE_URL, String.class);
		String response = forEntity.getBody();
		String string = response.toString();  
		return string;
	}
	
	
}
