package com.technews.repository;

import com.technews.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
//return type of List <Post> - find all Posts by User Id
    List<Post> findAllPostsByUserId(Integer id) throws Exception;

}
