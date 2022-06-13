package com.ec.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Consumer;
import com.ec.springApp.service.CommandService;

@CrossOrigin
@RestController
public class CommandController {

	@Autowired
	private CommandService commandService;

	@PostMapping("getCommand")
	public List<Command> getCommandsByUser(@RequestBody Consumer consumer) {
		return this.commandService.getCommandsByUser(consumer);
	}

	@PostMapping("addCommand")
	public void addCommand(@RequestBody Command command) {
		this.commandService.addCommand(command.getConsumer(), command.getProducts());
	}
	
	@PostMapping("updateCommand")
	public void updateCommand(@RequestBody Command command) {
		this.commandService.updateCommand(command);
	}
	
	@PostMapping("deleteCommand")
	public void deleteCommand(@RequestBody Command command) {
		this.commandService.deleteCommand(command);
	}
	
	@GetMapping("getAllCommands")
	public List<Command> findAllCommand() {
		return this.commandService.findAllCommand();
	}
}
