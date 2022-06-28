package com.ec.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.springApp.entites.Comment;
import com.ec.springApp.repository.ICommentRepository;

@Service
public class CommentService {

	@Autowired
	private ICommentRepository commentRepository;

	public void addComment(Comment comment) {
		this.commentRepository.save(comment);
	}
}
