package com.example.StudentManagementBySpringBoot.service;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //create student
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

//get all students
    public List<Student> getAllstudents() {
        return studentRepo.findAll();
    }

    //get by id
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }


    //update by id
    public Student updateStudentById(Long id, Student student) {

        for (Student stud : studentRepo.findAll()) {
            if (stud.getId().equals(id)) {
                stud.setName(student.getName());
                stud.setEmail(student.getEmail());
                stud.setPhone(student.getPhone());
                stud.setDob(student.getDob());
                stud.setEnrollmentDate(student.getEnrollmentDate());

                return studentRepo.save(stud);
            }
        }
        return null;
    }
}
