package com.ec.springApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Command;
import com.ec.springApp.entites.Comment;
import com.ec.springApp.entites.Holiday;
import com.ec.springApp.service.CommentService;

@CrossOrigin
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("saveComment")
	public void saveComment(@RequestBody Comment comment) {
		this.commentService.addComment(comment);
	}

	@GetMapping("getCommandComment")
	public Comment findCommentByCommand(@RequestBody Command command) {
		return this.commentService.findByCommand(command);
	}

	@GetMapping("getHolidayComment")
	public Comment findCommentByHolisay(@RequestBody Holiday holiday) {
		return this.commentService.findByHoliday(holiday);
	}
}
