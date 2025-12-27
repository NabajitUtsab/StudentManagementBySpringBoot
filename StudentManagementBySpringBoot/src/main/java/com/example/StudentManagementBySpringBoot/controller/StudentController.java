package com.example.StudentManagementBySpringBoot.controller;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private  StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
       studentService.addStudent(student);

        return new ResponseEntity<>("Student added successfully",HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<?> getAllStudents() {
//        studentService.getStudent();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
