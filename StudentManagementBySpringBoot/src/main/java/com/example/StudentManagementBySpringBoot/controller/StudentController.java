package com.example.StudentManagementBySpringBoot.controller;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private  StudentService studentService;

    //Add ing students
    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
       studentService.addStudent(student);

        return new ResponseEntity<>("Student added successfully",HttpStatus.CREATED);
    }

    //getting all students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = studentService.getAllstudents() ;
        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    //getting by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        //Student student = studentService.getStudentById(id);
        //return new ResponseEntity<>(student, HttpStatus.FOUND);
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //update by id
    @PutMapping("/{id}")

    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                @Valid @RequestBody Student student) {
        Student student1 = studentService.updateStudentById(id,student);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }
}
