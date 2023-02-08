package com.technews.model;

//Imports from annotations
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Class Level Annotations
//User class can map to a table
@Entity
//Properties (hibernateLazyInitializer and handler) ignored when serialized the object to JSON
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Specifies the name of the table that this class maps to (user)
@Table(name = "user")

//Instance Variables in User Class
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    boolean loggedIn;

    //Instance Variables - Lists - collections of objects of the same type
    private List<Post> posts;
    private List<Vote> votes;
    private List<Comment> comments;

}
