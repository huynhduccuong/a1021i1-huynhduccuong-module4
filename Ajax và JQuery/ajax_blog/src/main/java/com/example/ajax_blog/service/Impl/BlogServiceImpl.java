package com.example.ajax_blog.service.Impl;


import com.example.ajax_blog.model.bean.Blog;
import com.example.ajax_blog.model.bean.Category;
import com.example.ajax_blog.repository.BlogRepository;
import com.example.ajax_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.findById(id);
    }

    @Override
    public Iterable<Blog> findAllByBlog(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable) {
        return blogRepository.findAllByBlogNameContaining(blogName, pageable);
    }
}
