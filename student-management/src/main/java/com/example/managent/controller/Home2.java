package com.example.managent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home2 {
	 @GetMapping("/home2")
	    public String home() {
	        return "home/home2"; 
	    }

}
