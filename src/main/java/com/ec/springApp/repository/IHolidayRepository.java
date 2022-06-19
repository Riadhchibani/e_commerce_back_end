package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Holiday;

public interface IHolidayRepository extends JpaRepository<Holiday, Long>{

}
