package com.example.StudentManagementBySpringBoot.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batch")
@NoArgsConstructor
@AllArgsConstructor

public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @OneToMany(mappedBy = "batch",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;


}
