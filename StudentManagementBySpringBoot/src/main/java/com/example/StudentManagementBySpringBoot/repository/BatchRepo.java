package com.example.StudentManagementBySpringBoot.repository;

import com.example.StudentManagementBySpringBoot.model.Batch;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer> {

    Batch findByName(String name);

    boolean existsByName(String name);


}
