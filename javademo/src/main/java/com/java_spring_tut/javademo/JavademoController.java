package com.java_spring_tut.javademo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JavademoController {
    @GetMapping("/")
    public String showLoginPage() {
        return "index";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes attributes) {
        if ("user".equals(username) && "pass".equals(password)) {
            attributes.addFlashAttribute("message", "Login Successful!");
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("message", "Invalid Credentials!");
            return "redirect:/";
        }
    }
}
