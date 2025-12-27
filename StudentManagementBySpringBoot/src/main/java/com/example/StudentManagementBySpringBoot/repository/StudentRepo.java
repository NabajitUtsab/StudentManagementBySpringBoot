package com.example.StudentManagementBySpringBoot.repository;

import com.example.StudentManagementBySpringBoot.model.Batch;
import com.example.StudentManagementBySpringBoot.model.Student;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.sql.results.graph.Fetch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {



    Student findByEmail(String email);

    Student findById(Long id);

    //Student findByBatch(int batch);

    List<Student> findByNameContainingIgnoreCase(String name);
    //List<Student> findByBatchId(Long batchId);


}
