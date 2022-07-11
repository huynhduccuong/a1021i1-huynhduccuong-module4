package com.example.ajax_blog.repository;


import com.example.ajax_blog.model.bean.Blog;
import com.example.ajax_blog.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable);
}
