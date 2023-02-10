package com.technews.controller;

import com.technews.repository.CommentRepository;
import com.technews.repository.PostRepository;
import com.technews.repository.UserRepository;
import com.technews.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Class-Level annotation Controller
@Controller
public class TechNewsController {
    //Repository relationships
    @Autowired
    PostRepository postRepository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
}
