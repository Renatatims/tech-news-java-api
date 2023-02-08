package com.technews.repository;

import com.technews.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    //return type of List <Comment> - find all Comments by Post id - take an argument postId of value int
    List<Comment> findAllCommentsByPostId(int postId);
}
