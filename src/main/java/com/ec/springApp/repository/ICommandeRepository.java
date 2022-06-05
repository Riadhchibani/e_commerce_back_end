package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Command;

public interface ICommandeRepository extends JpaRepository<Command, Long>{

}
