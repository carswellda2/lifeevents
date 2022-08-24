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
		System.out.println("Someone is hittings your server from the web ...");
		System.out.println("Some events .... ");
		return "Dave's life events web service is heres ...not there ... everythrer "; 
	}
	
	@PostMapping("/welcome") 
	public ResponseEntity<String> print(@RequestBody String requestBody) {
		System.out.println("##### Calling your post  .... #####" + requestBody);
		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
	}
	
}
