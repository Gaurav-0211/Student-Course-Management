package com.management.dto;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String courseName;
    private String description;
    private int durationInWeeks;
}