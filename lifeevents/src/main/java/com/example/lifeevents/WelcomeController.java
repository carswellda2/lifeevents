package com.example.lifeevents;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhook")
public class WelcomeController {
	
	@GetMapping("/welcome")  
	public String welcome() {
		System.out.println("Someone is hitting your server from the web ...");
		System.out.println("Some event .... ");
		return "Dave's life events web service is here ...not there ... everythrer "; 
	}
	
	@PostMapping 
	public ResponseEntity<String> print(@RequestBody String requestBody) {
		System.out.println("##### Webhooks2 .... #####" + requestBody);
		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
	}
	
}
