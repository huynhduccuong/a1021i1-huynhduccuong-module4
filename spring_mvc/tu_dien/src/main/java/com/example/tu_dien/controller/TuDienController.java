package com.example.tu_dien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDienController {
    @GetMapping("/tudien")
    public String showView(){
        return "tudien";
    }

    @PostMapping("/tudien")
    public String moneychange(@RequestParam String search, Model model){
        if(search.equals("hello")){
            search = "xin chao";
        } else {
            search = "haha";
        }
        model.addAttribute("search", search);
        return  "tudien";
    }
}
