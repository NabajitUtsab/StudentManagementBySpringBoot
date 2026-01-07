package com.example.StudentManagementBySpringBoot.service;

import com.example.StudentManagementBySpringBoot.model.Batch;
import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.repository.BatchRepo;
import com.example.StudentManagementBySpringBoot.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service

public class StudentService {


    @Autowired
    private StudentRepo studentRepo;
    @Autowired
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


    public Student assignBatchToStudent(Long studentId, Long batchId) throws Throwable {

        Student student = (Student) studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Batch batch = (Batch) batchRepo.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        student.setBatch(batch);     // ⭐ THIS is the key line

        return studentRepo.save(student);
    }

    //pagination using Pagable.ofSize

//    public List<Student> findingAllStudentsByName(String name) {
//       return studentRepo.findByNameIgnoreCase(name,Pageable.ofSize(10));
//    }

    //pagination using PageRequest.of(pageNumber,pageSize)

    public List<Student> findingAllStudentsByName(String name,int pageNumber,int pageSize)  {
        return studentRepo.findByNameIgnoreCase(name, PageRequest.of(pageNumber,pageSize));
    }

    // Sorting

    public List<Student> sortingAllStudentsByPhone()
    {
      return studentRepo.sortByPhone(Sort.by("phone").descending());
    }


    public void populateDemo(int n) {
        if (n <= 0 || n > 1000) {
            throw new RuntimeException("Population should be between 1 and 1000");
        }

        Random random = new Random();

        String[] firstNames = {"Tareq", "Nuran", "Fahim", "Sakib", "Towhid", "Mushfiq", "Rahat", "Shorif", "Tuhin", "Tanvir"};
        String[] lastNames = {"Islam", "Mahbub", "Alam", "Zaman", "Ferdous", "Ali", "Bin Ahsan"};
        String[] domains = {"gmail.com", "hotmail.com", "yahoo.com", ".edu.ac.bd"};

        for (int i = 0; i < n; i++) {

            Student student = new Student();
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];

            student.setName(firstName + " " + lastName);

            String emailDomain = domains[random.nextInt(domains.length)];
            student.setEmail(firstName.toLowerCase() + lastName.toLowerCase() + i + "@" + emailDomain);

            String phoneNumber = "01" + String.format("%9d", random.nextInt(1000000000));
            student.setPhone(phoneNumber);

            LocalDate dob = LocalDate.now().minusYears(18 + random.nextInt(8)).minusDays(365);
            student.setDob(dob);

            LocalDate enrollmentDate = LocalDate.now().minusDays(random.nextInt(365));
            student.setEnrollmentDate(enrollmentDate);

            student.setBatch((Batch) batchRepo.findById(1L).orElseThrow());

            studentRepo.save(student);
        }

    }

}
