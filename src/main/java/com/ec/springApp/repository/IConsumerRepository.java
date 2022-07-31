package com.ec.springApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.springApp.entites.Consumer;


public interface IConsumerRepository extends JpaRepository<Consumer, Long>{
	
	@Query("SELECT consumer FROM Consumer consumer WHERE consumer.username = :username AND consumer.password = :password")
	public Consumer findConsumerbyUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
//	@Query("SELECT consumer FROM Consumer consumer WHERE consumer.username = :username")
	public Optional<Consumer> findByUsername(String username);
	
	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
}
