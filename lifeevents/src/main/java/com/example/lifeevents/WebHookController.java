package com.example.lifeevents;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/webhooks") 
public class WebHookController {
	
	//@KafkaListener(topics = "NewTopic2", groupId = "group_id")

	@GetMapping("/consume")  
	public String welcome() {
		
		System.out.println("Something is calling the webhook controller ...");
		System.out.println("This will act as a kafka consumer  .... ");

		return "Web hook successfully called, and 'consumed' by Kafka running on your local machine .... "; 
	}
	
	@PostMapping("/consume") 
	public ResponseEntity<String> print(@RequestBody String requestBody) {
		System.out.println("##### Calling your post todays  .... #####" + requestBody);
		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
	}	
	
//	@PostMapping 
//	public ResponseEntity<String> print(@RequestBody String requestBody) { 
//		System.out.println("##### Webhooks #####" + requestBody);
//		return new ResponseEntity<String>(requestBody, HttpStatus.OK); 
//	}
}
