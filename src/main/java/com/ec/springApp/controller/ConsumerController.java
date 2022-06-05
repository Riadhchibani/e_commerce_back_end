package com.ec.springApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Consumer;
import com.ec.springApp.service.ConsumerService;

@RestController
public class ConsumerController {

	private ConsumerService consumerService;

	public ConsumerController(ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	@PostMapping
	public void addConsumer(@RequestBody Consumer consumer) {
		this.consumerService.addConsumer(consumer);
	}

	@GetMapping
	public List<Consumer> findConsumers() {
		return this.consumerService.findAllConsumer();
	}
}
