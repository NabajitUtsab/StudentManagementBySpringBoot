package com.example.StudentManagementBySpringBoot.controller;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Add ing students
    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);

        return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
    }

    //getting all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudentsAPI() {
        List<Student> studentList = studentService.getAllstudents();
        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    //getting by id
    @GetMapping("/id/{id}")
    public ResponseEntity<Student> getStudentAPI(@PathVariable Long id) {
        //Student student = studentService.getStudentById(id);
        //return new ResponseEntity<>(student, HttpStatus.FOUND);
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    //getting by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {

        return studentService.getStudentByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    //update by id
    @PutMapping("/{id}")

    public ResponseEntity<Student> updateStudentAPI(@PathVariable Long id,
                                                    @Valid @RequestBody Student student) {
        Student student1 = studentService.updateStudentById(id, student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }


    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentAPI(@PathVariable Long id) {

        studentService.deleteStudentById(id);
        return new ResponseEntity<>(id + " No. Student deleted successfully", HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllStudentsAPI() {
        studentService.deleteAllStudents();
        return new ResponseEntity<>("All students deleted successfully", HttpStatus.OK);
    }


    //update batch id
    @PutMapping("/{studentId}/batch/{batchId}")
    public ResponseEntity<Student> assignBatch(
            @PathVariable Long studentId,
            @PathVariable Long batchId) throws Throwable {

        Student updatedStudent =
                studentService.assignBatchToStudent(studentId, batchId);

        return ResponseEntity.ok(updatedStudent);
    }

    /// Generating data by default
    @PostMapping("/populate")
    public ResponseEntity<String> populateStudentAPI(@RequestParam int n) throws Throwable {

        try{
            studentService.populateDemo(n);
            return  ResponseEntity.ok("Successfully created " + n + " demo students");
        }catch (RuntimeException runtimeException){
            return ResponseEntity.badRequest().body("Error: " + runtimeException.getMessage());

        }
    }

    //pagination
    @GetMapping("/page/{name}")
//    public ResponseEntity<List<Student>> getAllStudentsAPIusingPagination(@PathVariable String name) {
//        try{
//            List<Student> studentLists = studentService.findingAllStudentsByName(name);
//            return new ResponseEntity<>(studentLists,HttpStatus.OK);
//        }catch (RuntimeException runtimeException){
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
    public ResponseEntity<List<Student>> getAllStudentsAPIusingPagination(@PathVariable String name,@RequestParam int pageNumber,@RequestParam int pageSize) {
        try{
            List<Student> studentLists = studentService.findingAllStudentsByName(name,pageNumber,pageSize);
            return new ResponseEntity<>(studentLists,HttpStatus.OK);
        }catch (RuntimeException runtimeException){
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/sort")
    public ResponseEntity<List<Student>> getStudentsByNameSortedByPhone(
            @RequestParam String name) {

        return ResponseEntity.ok(
                studentService.getStudentsByNameSortedByPhone(name)
        );
    }



}
