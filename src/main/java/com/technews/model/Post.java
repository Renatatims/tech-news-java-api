package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.sun.istack.NotNull;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//Class Level Annotations
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "post")

//Instance Variables in Post Class
public class Post implements Serializable {
    //ID annotations
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;

    //userName annotations
    @Transient
    private String userName;

    //voteCount annotation
    @Transient
    private int voteCount;

    private Integer userId;

    //Date annotations
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    //Table relationship for the Post Class
    //Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Comment> comments;

    //Constructor
    public Post() {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.userName = userName;
        this.voteCount = voteCount;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return getVoteCount() == post.getVoteCount() &&
                Objects.equals(getId(), post.getId()) &&
                Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getPostUrl(), post.getPostUrl()) &&
                Objects.equals(getUserName(), post.getUserName()) &&
                Objects.equals(getUserId(), post.getUserId()) &&
                Objects.equals(getPostedAt(), post.getPostedAt()) &&
                Objects.equals(getUpdatedAt(), post.getUpdatedAt()) &&
                Objects.equals(getComments(), post.getComments());
    }
    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserId(), getPostedAt(), getUpdatedAt(), getComments());
    }

    //toString
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
