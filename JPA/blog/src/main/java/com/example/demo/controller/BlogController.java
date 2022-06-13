package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.sun.swing.internal.plaf.basic.resources.basic_ko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("create")
    public String displayCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("blogs") Blog blog, Model model){
        blogService.save(blog);
        return "redirect:list";
    }

    @GetMapping("list")
    public String listBlog(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:list";
    }

    @GetMapping("detail/{id}")
    public String showDetailBlog(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }

    @GetMapping("delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "delete";
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:list";
    }
}
