package com.example.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener; 

public class RabbitMQMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		//when message comes to the wuw you listen and do processing 
		System.out.println(new String(message.getBody()));
	}

}
