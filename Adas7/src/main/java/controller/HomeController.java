package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { // Trang Chu

    @GetMapping("/")
    public String home(Model model) {
        // Điều hướng đến trang chủ và trả về tên template
        return "index";
    }
}