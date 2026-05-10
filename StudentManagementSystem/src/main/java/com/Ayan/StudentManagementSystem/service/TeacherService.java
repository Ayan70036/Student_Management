package com.Ayan.StudentManagementSystem.service;

import com.Ayan.StudentManagementSystem.entity.Teacher;
import com.Ayan.StudentManagementSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public Teacher register(Teacher teacher) {
        teacher.setPassword(encoder.encode(teacher.getPassword()));
        return repo.save(teacher);
    }

    public boolean login(String email, String password) {
        Teacher teacher = repo.findByEmail(email);

        if (teacher != null && encoder.matches(password, teacher.getPassword())) {
            return true;
        }

        return false;
    }
}