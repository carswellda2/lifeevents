package com.example.lifeevents;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;


// 08.29.2022 - Entire class new today 
public class KafkaProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers; 
	
	public Map<String, Object> producerConfig() { 
		Map<String, Object> props = new HashMap<>(); 
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers); 
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_DOC, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); 
		return props; 
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactory() { 
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(
		ProducerFactory<String, String> producerFactory
		) {
		return new KafkaTemplate<>(producerFactory); 			
	}
}
