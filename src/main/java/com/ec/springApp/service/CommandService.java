package com.ec.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.repository.ICommandeRepository;

@Service
public class CommandService {

	@Autowired
	private ICommandeRepository commandeRepository;
}
