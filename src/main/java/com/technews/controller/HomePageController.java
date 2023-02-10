package com.technews.controller;

import ch.qos.logback.core.model.Model;
import com.technews.model.User;
import com.technews.repository.CommentRepository;
import com.technews.repository.PostRepository;
import com.technews.repository.UserRepository;
import com.technews.repository.VoteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Class-level annotation - Controller will control flow for the front-end
@Controller
public class HomePageController {

    //Relationships for all the repositories - user, post, vote and comment
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    CommentRepository commentRepository;

    //Login endpoint
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        if (request.getSession(false) != null) {
            return "redirect:/";
        }
    // Will send a newly created user to the template as the string user - will be displayed within the template
        model.addAttribute("user", new User());
        return "login";
    }

    //Logout endpoint - checks if the session exists
    @GetMapping("/users/logout")
    public String logout(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }
}


