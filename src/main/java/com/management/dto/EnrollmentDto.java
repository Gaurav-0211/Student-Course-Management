package com.management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate enrolledOn;
    private String status;
}
