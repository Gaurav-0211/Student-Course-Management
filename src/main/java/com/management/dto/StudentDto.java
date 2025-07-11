package com.management.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private List<Long> courseIds;
}