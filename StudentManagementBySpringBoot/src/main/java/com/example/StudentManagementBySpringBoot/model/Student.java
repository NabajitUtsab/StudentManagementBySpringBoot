package com.example.StudentManagementBySpringBoot.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "student")

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor


public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column(unique = true, nullable = false)
    @NonNull
    private String email;

    @Column(unique = true, nullable = false)
    @NonNull
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "date_of_enrollment")
    private LocalDate enrollmentDate;

}
