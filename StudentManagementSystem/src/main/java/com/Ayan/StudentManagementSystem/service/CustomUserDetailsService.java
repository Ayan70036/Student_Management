package com.Ayan.StudentManagementSystem.service;

import com.Ayan.StudentManagementSystem.entity.Teacher;
import com.Ayan.StudentManagementSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TeacherRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) {

        Teacher teacher = repo.findByEmail(email);

        if (teacher == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(teacher.getEmail())
                .password(teacher.getPassword())
                .roles("TEACHER")
                .build();
    }
}