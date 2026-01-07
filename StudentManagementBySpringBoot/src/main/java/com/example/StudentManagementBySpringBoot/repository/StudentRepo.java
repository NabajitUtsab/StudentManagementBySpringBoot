package com.example.StudentManagementBySpringBoot.repository;

import com.example.StudentManagementBySpringBoot.model.Batch;
import com.example.StudentManagementBySpringBoot.model.Student;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.sql.results.graph.Fetch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {



    Optional findByEmail(String email);

    Optional findById(Long id);

    List<Student> findByNameIgnoreCase(String name , Pageable pageable);
    List<Student> sortByPhone(Sort sort);


    //Student findByBatch(int batch);

    List<Student> findByNameContainingIgnoreCase(String name);
    //List<Student> findByBatchId(Long batchId);


}
