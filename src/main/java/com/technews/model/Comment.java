package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//Class-Level Annotations and Implementations
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "comment")

//Instance Variables
public class Comment implements Serializable {
    //ID annotations
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String commentText;
    private Integer userId;
    private Integer postId;

    //METHODS

    //Constructor
    public Comment(Integer id, String commentText, Integer userId, Integer postId) {
        this.id = id;
        this.commentText = commentText;
        this.userId = userId;
        this.postId = postId;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return Objects.equals(getId(), comment.getId()) && Objects.equals(getCommentText(), comment.getCommentText()) && Objects.equals(getUserId(), comment.getUserId()) && Objects.equals(getPostId(), comment.getPostId());
    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommentText(), getUserId(), getPostId());
    }

    //toString
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
