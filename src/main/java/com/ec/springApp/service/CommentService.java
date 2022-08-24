package com.ec.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Comment;
import com.ec.springApp.entites.Holiday;
import com.ec.springApp.repository.ICommentRepository;

@Service
public class CommentService {

	@Autowired
	private ICommentRepository commentRepository;

	public void addComment(Comment comment) {
		this.commentRepository.save(comment);
	}

	public String findByCommand(Command command) {
		return (this.commentRepository.findByCommand(command) == null ? null
				: this.commentRepository.findByCommand(command).getDescription());
	}

	public String findByHoliday(Holiday holiday) {
		return (this.commentRepository.findByHoliday(holiday) == null ? ""
				: this.commentRepository.findByHoliday(holiday).getDescription());
	}
}
