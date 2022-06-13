package com.ec.springApp.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Consumer;
import com.ec.springApp.entites.Product;
import com.ec.springApp.repository.ICommandeRepository;

@Service
public class CommandService {

	@Autowired
	private ICommandeRepository commandeRepository;

	public List<Command> getCommandsByUser(Consumer consumer) {
		return this.commandeRepository.findByConsumer(consumer);
	}

	public void addCommand(Command command) {
        String reference = UUID.randomUUID().toString();
       
		command.setDateCreation(new Date());
		command.setDateValidation(new Date());
		command.setStatus("En attente");
		command.setReference("Ref-"+reference.substring(reference.length() - 4));
		this.commandeRepository.save(command);
	}
	
	public void updateCommand(Command command) {
		this.commandeRepository.save(command);
	}
	
	public void deleteCommand(Command cmd) {
		this.commandeRepository.delete(cmd);
	}

	public List<Command> findAllCommand() {
		return this.commandeRepository.findAll();
	}
}
