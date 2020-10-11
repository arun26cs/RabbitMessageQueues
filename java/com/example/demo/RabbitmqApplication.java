package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Student;

@SpringBootApplication
public class RabbitmqApplication implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//rabbitTemplate.convertAndSend("This is string message");// if not bound it wont be caught
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Arun");
		//rabbitTemplate.convertAndSend("TRExchange","TRoutingKey","Hello world");//worked
		rabbitTemplate.convertAndSend("TRExchange","TRoutingKey",s1);
		
	}

}
