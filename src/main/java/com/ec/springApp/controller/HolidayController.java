package com.ec.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Holiday;
import com.ec.springApp.service.HolidayService;

@RestController
@CrossOrigin
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@PostMapping("/saveHoliday")
	public void saveHoliday(@RequestBody Holiday holiday) {
		this.holidayService.saveHoliday(holiday);
	}

	@GetMapping("/findAllHoliday")
	public List<Holiday> findAllHoliday() {
		return this.holidayService.findAllHoliday();
	}

	@PutMapping("/updateHolidayStatus")
	public Holiday updateStatus(@RequestBody Holiday holiday) {
		return this.holidayService.updateStatus(holiday);
	}

	@DeleteMapping("/deleteAllHoliday")
	public void deleteAllHoliday() {
		this.holidayService.deleteHoliday();
	}
}
