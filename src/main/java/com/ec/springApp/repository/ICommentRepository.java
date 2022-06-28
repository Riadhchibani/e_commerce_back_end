package com.ec.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.springApp.entites.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

}
