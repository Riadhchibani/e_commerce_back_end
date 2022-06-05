package com.ec.springApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.service.CommandService;

@RestController
public class CommandController {

	private CommandService commandService;

	public CommandController(CommandService commandService) {
		this.commandService = commandService;
	}
}
