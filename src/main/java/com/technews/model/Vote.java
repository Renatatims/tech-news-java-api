package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//Class-Level Annotations
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "vote")

//Instance Variables in Vote class
public class Vote implements Serializable {
    //ID annotations
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer postId;

    //METHODS

    //Constructor
    public Vote(Integer id, Integer userId, Integer postId) {
        this.id = id;
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

    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote vote)) return false;
        return Objects.equals(getId(), vote.getId()) &&
                Objects.equals(getUserId(), vote.getUserId()) &&
                Objects.equals(getPostId(), vote.getPostId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getPostId());
    }

    //toString
    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
