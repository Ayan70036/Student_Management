package com.Ayan.StudentManagementSystem.controller;

import com.Ayan.StudentManagementSystem.entity.Student;
import com.Ayan.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    // ===============================
    // HOME PAGE
    // ===============================
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // ===============================
    // LIST ALL STUDENTS
    // ===============================
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    // ===============================
    // SHOW CREATE FORM
    // ===============================
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    // ===============================
    // SAVE / UPDATE STUDENT + FILE
    // ===============================
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student,
                              @RequestParam("file") MultipartFile file) {

        try {

            // 📁 Define upload folder
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // ✅ IF NEW FILE UPLOADED
            if (!file.isEmpty()) {

                // 🔥 UNIQUE FILE NAME (avoid overwrite)
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, file.getBytes());

                // Save filename in DB
                student.setResumeFileName(fileName);

            } else {
                // 🔥 KEEP OLD FILE WHEN EDITING
                if (student.getId() != null) {
                    Student existing = (Student) service.getStudentById(student.getId());
                    if (existing != null) {
                        student.setResumeFileName(existing.getResumeFileName());
                    }
                }
            }

            service.saveStudent(student);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/students";
    }

    // ===============================
    // EDIT STUDENT
    // ===============================
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = (Student) service.getStudentById(id);
        model.addAttribute("student", student);
        return "create_student"; // reuse same form
    }

    // ===============================
    // DELETE STUDENT
    // ===============================
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}