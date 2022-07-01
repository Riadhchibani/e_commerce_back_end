package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Comment;
import com.ec.springApp.entites.Holiday;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

	public Comment findByHoliday(Holiday holiday);
	
	public Comment findByCommand(Command command);
	

}