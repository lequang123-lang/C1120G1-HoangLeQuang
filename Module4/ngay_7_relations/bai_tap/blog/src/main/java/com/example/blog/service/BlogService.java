package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void deleteById(Integer id);
    void save(Blog blog);
    Page<Blog> findAllByOrderByDateReleaseAsc(Pageable pageable);
    Page<Blog> findAllByNameBlogContaining (String nameBlog, Pageable pageable);
    Page<Blog> findAllByCategoryContaining(List<Category> category, Pageable pageable);
}
