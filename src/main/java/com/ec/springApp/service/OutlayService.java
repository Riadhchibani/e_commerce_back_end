package com.ec.springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.entites.Outlay;
import com.ec.springApp.repository.IOutlayRepository;

@Service
public class OutlayService {

	@Autowired
	private IOutlayRepository outlayRepository;
	
	public void addOutlay(Outlay oulay) {
		this.outlayRepository.save(oulay);
	}
	
	public List<Outlay> findAllOutlay(){
		return this.outlayRepository.findAll();
	}
}
