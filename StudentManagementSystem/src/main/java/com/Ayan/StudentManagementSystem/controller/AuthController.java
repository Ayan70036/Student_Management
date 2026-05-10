package com.Ayan.StudentManagementSystem.controller;

import com.Ayan.StudentManagementSystem.entity.Teacher;
import com.Ayan.StudentManagementSystem.repository.TeacherRepository;
import com.Ayan.StudentManagementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private TeacherRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Teacher teacher) {
        teacher.setPassword(encoder.encode(teacher.getPassword()));
        repo.save(teacher);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}