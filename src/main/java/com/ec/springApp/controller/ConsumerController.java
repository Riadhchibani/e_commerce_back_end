package com.ec.springApp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Consumer;
import com.ec.springApp.service.ConsumerService;

@RestController
@CrossOrigin
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;

	@PostMapping("addConsumer")
	public void addConsumer(@RequestBody Consumer consumer) {
		this.consumerService.addConsumer(consumer);
	}

	@GetMapping("getConsumers")
	public List<Consumer> findConsumers() {
		return this.consumerService.findAllConsumer();
	}
	
	@GetMapping("getConsumer")
	public Consumer findConsumerByUsernameAndPassword(@PathParam("username") String username, @PathParam("password") String password) {
		return this.consumerService.findConsumerbyUsernameAndPassword(username, password);
	}
}
