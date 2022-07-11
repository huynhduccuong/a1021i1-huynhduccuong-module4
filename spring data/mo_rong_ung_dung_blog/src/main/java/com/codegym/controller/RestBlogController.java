package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestBlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category/list")
    public ResponseEntity<List<Category>> categoryList(){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/blog/list")
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable Long id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity viewCategory(@PathVariable("id") Category category) {
        List<Blog> blogs = blogService.findAllByCategory(category);
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
//    @PostMapping
//    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
//        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
//    }


}
