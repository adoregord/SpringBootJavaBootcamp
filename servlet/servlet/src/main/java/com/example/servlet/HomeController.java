package com.example.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        Person person = new Person("John Doe", 25);
        model.addAttribute("person", person);
        return "home"; // nama template tanpa ekstensi, misalnya home.html
    }
}