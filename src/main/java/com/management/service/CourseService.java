package com.management.service;

import com.management.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
    void deleteCourse(Long id);
}
