package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Comment;
import com.ec.springApp.entites.Holiday;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
	
	@Query("SELECT comment FROM Comment comment WHERE comment.holiday = :holiday")
	public Comment findByHoliday(Holiday holiday);

	@Query("SELECT comment FROM Comment comment WHERE comment.command = :command")
	public Comment findByCommand(Command command);
	

}
