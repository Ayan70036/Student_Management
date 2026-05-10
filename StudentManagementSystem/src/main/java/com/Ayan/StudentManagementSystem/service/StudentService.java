package com.Ayan.StudentManagementSystem.service;

import com.Ayan.StudentManagementSystem.controller.StudentController;
import com.Ayan.StudentManagementSystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Object getStudentById(Long id);
    public Object saveStudent(Student student);
    public Object updateStudent(Long id, Student student);
    public void deleteStudent(Long id);
}
