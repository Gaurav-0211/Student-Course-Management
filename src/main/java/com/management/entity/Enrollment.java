package com.management.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrolled_on")
    private LocalDate enrolledOn;

    @Column(name = "status")
    private String status;
}
