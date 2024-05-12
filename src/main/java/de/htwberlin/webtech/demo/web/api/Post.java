package de.htwberlin.webtech.demo.web.api;

import javax.persistence.*;
import java.time.LocalDateTime;


public class Post {


    private Long id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime createdAt;

    public Post(long id, String title, String content, String author, LocalDateTime createdAt) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
