package com.example.blog.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "blogs")
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBlog;
    @Column(columnDefinition = "date")
    private String dateRelease;
    private String content;
    private String writer;

    public Blog() {
    }

    public Blog(String nameBlog, String dateRelease, String content, String writer) {
        this.nameBlog = nameBlog;
        this.dateRelease = dateRelease;
        this.content = content;
        this.writer = writer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}