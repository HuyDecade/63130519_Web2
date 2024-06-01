package com.example.managent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.managent.model.User;
import com.example.managent.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "login"; // This corresponds to login.html in the templates directory
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        User users;
        try {
        	users = (User) userService.loadUserByUsername(user.getUsername());
            if (users != null) {
               // System.out.println("Load ảnh: " + users.getAvatar());
                model.addAttribute("authentication", users);

                boolean isAdmin = users.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

                if (isAdmin) {
                    return "redirect:/admin/";
                } else {
                    return "redirect:/home2";
                }
            } else {
                System.out.println("CustomUserDetails is null!");
                model.addAttribute("errorMessage", "Tên người dùng hoặc mật khẩu không chính xác!");
                return "login";
            }
        } catch (UsernameNotFoundException e) {
            System.out.println("Tên người dùng không tồn tại.");
            model.addAttribute("errorMessage", "Tên người dùng hoặc mật khẩu không chính xác!");
            return "login";
        }
    }
}
