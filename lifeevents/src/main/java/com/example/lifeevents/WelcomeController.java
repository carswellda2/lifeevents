package com.example.lifeevents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	final static Logger logger = LogManager.getLogger(WelcomeController.class); 
	
	@GetMapping("/welcome")  
	public String welcome() {
		logger.info("Someone is hitting your server from the web ...");
		return "Successfull GET call to the webhook .... most likely came from a browser ....  "; 
	}
	
	@PostMapping("/welcome") 
	public ResponseEntity<String> print(@RequestBody String requestBody) {
		logger.info("Successful POST call to the webhook .... most likely came from a GIThub action. Here's the payload request .....  " + requestBody); 
		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
	}
	
}
