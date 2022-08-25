package com.example.lifeevents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LifeeventsApplication {
	
	final static Logger logger = LogManager.getLogger(LifeeventsApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(LifeeventsApplication.class, args);
		
		logger.debug("Debug statement here .... ");
		logger.info("First logger info statement ....." );
		
		
		logger.info("Life events application is up and running  .... ");
		logger.info("This message (and the one above) is generated on application startup.... ");
	
	}

}
