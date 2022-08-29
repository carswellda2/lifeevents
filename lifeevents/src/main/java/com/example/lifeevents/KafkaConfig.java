package com.example.lifeevents;

//Java Program to Illustrate Kafka Configuration

//Importing required classes
import java.util.HashMap;
import java.util.Map;

// DAC NEW 08.29.2022 
import org.apache.kafka.clients.admin.NewTopic;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

//Annotations
@EnableKafka
@Configuration

//Class
public class KafkaConfig {

	@Bean
	public ConsumerFactory<String, String> consumerFactory()
	{

		// Creating a Map of string-object pairs
		Map<String, Object> config = new HashMap<>();

		// Adding the Configuration
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG,
				"group_id");
		config.put(
			ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
			StringDeserializer.class);
		config.put(
			ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
			StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config);
	}

	// Creating a Listener
	public ConcurrentKafkaListenerContainerFactory
	concurrentKafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<
			String, String> factory
			= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	// New 8/29/2022 
	// @BEAN is so this gets instantiated 
//	@Bean  
//	public NewTopic davesTopic() { 
//		return TopicBuilder.name("daves")
//				.build(); 
//	}
	// END DAC 
}

