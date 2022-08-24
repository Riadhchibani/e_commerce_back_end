package com.ec.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ec.springApp.entites.Consumer;
import com.ec.springApp.entites.Subscriber;
import com.ec.springApp.service.ConsumerService;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	
	@Autowired
	private ConsumerService consumerService;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Consumer consumer = new Consumer();
		consumer.setLastName("mohamed");
		consumer.setFirstName("ahmed");
		consumer.setUsername("mohamed");
		consumer.setPassword("1234");
		consumerService.addConsumer(consumer);
		
		Consumer subscriberAdmin = new Consumer();
		subscriberAdmin.setLastName("ahmed");
		subscriberAdmin.setFirstName("amir");
		subscriberAdmin.setUsername("amir");
		subscriberAdmin.setPassword("1234");
		subscriberAdmin.setRole("admin");
		consumerService.addConsumer(subscriberAdmin);
	}

}
