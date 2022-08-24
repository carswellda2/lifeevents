package com.example.lifeevents;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/webhooks") 
public class WebHookController {

	@PostMapping 
	public ResponseEntity<String> print(@RequestBody String requestBody) { 
		System.out.println("##### Webhooks #####" + requestBody);
		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
	}
}
