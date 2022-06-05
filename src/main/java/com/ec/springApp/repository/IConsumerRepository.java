package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Consumer;


public interface IConsumerRepository extends JpaRepository<Consumer, Long>{

}
