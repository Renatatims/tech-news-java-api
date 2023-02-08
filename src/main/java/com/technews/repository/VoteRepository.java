package com.technews.repository;

import com.technews.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    //Instance-Level annotation - will take a single argument - specific query
    @Query("SELECT count(*) FROM Vote v where v.postId = :id")
    //Method with 2 parameters: method-level annotation @Param("id") to use the id as a parameter and the Integer id.
    int countVotesByPostId(@Param("id") Integer id);
}