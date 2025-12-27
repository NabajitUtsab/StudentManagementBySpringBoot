package com.example.StudentManagementBySpringBoot.service;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }


}
