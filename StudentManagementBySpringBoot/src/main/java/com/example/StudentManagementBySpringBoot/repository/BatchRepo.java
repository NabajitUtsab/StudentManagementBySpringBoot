package com.example.StudentManagementBySpringBoot.repository;

import com.example.StudentManagementBySpringBoot.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer> {

    Optional<Object> findByName(String name);

    boolean existsByName(String name);


    Optional<Object> findById(Long id);

    void deleteById(Long id);
}
