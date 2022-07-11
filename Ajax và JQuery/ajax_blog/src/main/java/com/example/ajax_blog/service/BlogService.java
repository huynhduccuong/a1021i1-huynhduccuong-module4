package com.example.ajax_blog.service;


import com.example.ajax_blog.model.bean.Blog;
import com.example.ajax_blog.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByBlog(Category category);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable);
}
