package com.technews.model;

//Imports from annotations
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

//Class Level Annotations
//User class can map to a table
@Entity
//Properties (hibernateLazyInitializer and handler) ignored when serialized the object to JSON
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Specifies the name of the table that this class maps to (user)
@Table(name = "user")

//Instance Variables in User Class
public class User {
    //Id annotations - Id unique identifier and generated value automatically
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;

    //Email annotation - value must be unique (duplicates not allowed in the database)
    @Column(unique = true)
    private String email;
    private String password;

    //Logged In annotation - user's logged-in status won't persist in the data
    @Transient
    boolean loggedIn;

    //Table Relationships for the User Class

    //Post list - fetch type eager: information will be gathered immediately after being created
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;

    // Vote List - Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;

    // Comment List - Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    //Instance Variables - Lists - collections of objects of the same type
    private List<Post> posts;
    private List<Vote> votes;
    private List<Comment> comments;

}
