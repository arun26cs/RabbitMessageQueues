package com.example.demo;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	//provide queue
	//provide connection
	//bind queue and connection to the listener
	
	private static final String queue = "MyJavaQueue";
	
	@Bean
	Queue queue() {
	
		return new Queue(queue,true);
	}
	
	
	@Bean
	ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
		
	}
	
	@Bean
	MessageListenerContainer messageListener() {
		SimpleMessageListenerContainer smlc = new SimpleMessageListenerContainer();
		smlc.setConnectionFactory(cachingConnectionFactory());
		smlc.setQueues(queue());
		smlc.setMessageListener(new RabbitMQMessageListener());
		return smlc;
		 
	};
}
