package com.example.managent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home/index"; 
    }

    @GetMapping("/home")
    public String homePage() {
        return "home/index"; 
    }
}
