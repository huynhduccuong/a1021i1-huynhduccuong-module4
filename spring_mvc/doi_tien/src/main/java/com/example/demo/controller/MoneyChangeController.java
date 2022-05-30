package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyChangeController {
    @GetMapping("/moneychange")
    public String showView() {
        System.out.println("a");
        return "change";
    }

    @PostMapping("/moneychange")
    public String moneychange(@RequestParam float usd, Model model) {
        float vnd = 23 * usd;
        model.addAttribute("vnd", vnd);
        return "change";
    }
}
