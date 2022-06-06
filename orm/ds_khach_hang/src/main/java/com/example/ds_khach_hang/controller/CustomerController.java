package com.example.ds_khach_hang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String view(){
        return "home";
    }
}
