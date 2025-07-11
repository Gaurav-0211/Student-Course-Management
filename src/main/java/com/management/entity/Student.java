package com.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "f_name", nullable = false)
    private String f_name;

    @Column(name = "l_name", nullable = false)
    private String l_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "enrollment_date")
    private LocalDate doe;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;
}
