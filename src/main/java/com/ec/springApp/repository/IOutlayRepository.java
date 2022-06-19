package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Outlay;

public interface IOutlayRepository extends JpaRepository<Outlay, Long> {

}
