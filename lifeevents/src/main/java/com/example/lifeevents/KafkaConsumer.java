package com.example.lifeevents;

//Importing required classes
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component

//Class
public class KafkaConsumer {
	
	final static Logger logger = LogManager.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "NewTopic2",
				groupId = "group_id")

	// Method
	public void
	consume(String message)
	{
		// Print statement
		logger.info("message .... " +  message);
	}
}
