package com.example.StudentManagementBySpringBoot.repository;

import com.example.StudentManagementBySpringBoot.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer> {

    Optional<Object> findByName(String name);

    boolean existsByName(String name);


    Optional findById(Long id);

    //Batch deleteById(Long id);

    Batch removeById(Long id);
}
