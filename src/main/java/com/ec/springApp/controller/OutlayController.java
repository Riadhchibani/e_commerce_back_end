package com.ec.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Outlay;
import com.ec.springApp.service.OutlayService;

@RestController
@CrossOrigin
public class OutlayController {

	@Autowired
	private OutlayService outlayService;

	@PostMapping("/addOutlay")
	public void addOutlay(@RequestBody Outlay outlay) {
		this.outlayService.addOutlay(outlay);
	}
	
	@GetMapping("/findOutlay")
	public List<Outlay> findAllOutlay() {
		return this.outlayService.findAllOutlay();
	}
}
