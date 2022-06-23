package com.ec.springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.entites.Holiday;
import com.ec.springApp.entites.STATUS_HOLIDAY;
import com.ec.springApp.repository.IHolidayRepository;

@Service
public class HolidayService {

	@Autowired
	private IHolidayRepository holidayRepository;

	public void saveHoliday(Holiday holiday) {
		holiday.setStatus(STATUS_HOLIDAY.EN_COURS.toString());
		holiday.setNumberDay((int) Math.abs(holiday.getEndDate().getTime() - holiday.getBeginDate().getTime()));
		this.holidayRepository.save(holiday);
	}

	public List<Holiday> findAllHoliday() {
		return this.holidayRepository.findAll();
	}

	public Holiday updateStatus(Holiday holiday) {
		return this.holidayRepository.save(holiday);
	}

	public void deleteHoliday() {
		this.holidayRepository.deleteAll();
	}
}
