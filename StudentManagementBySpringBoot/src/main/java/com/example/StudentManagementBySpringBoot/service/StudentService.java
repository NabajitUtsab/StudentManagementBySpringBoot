package com.example.StudentManagementBySpringBoot.service;

import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.repository.BatchRepo;
import com.example.StudentManagementBySpringBoot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    private BatchRepo batchRepo;

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

    //get by email
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }


    //update by id
    public Student updateStudentById(Long id, Student student) {

        try {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //delete by id
    public void deleteStudentById(Long id) {
         studentRepo.deleteById(Math.toIntExact(id));
    }

    //delete all products
    public void deleteAllStudents() {
        studentRepo.deleteAll();
    }
}
