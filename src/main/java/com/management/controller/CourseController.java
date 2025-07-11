package com.management.controller;

import com.management.dto.CourseDto;
import com.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Long id){
        return courseService.getCourseById(id);
    }
    @GetMapping
    public List<CourseDto> getAllCourse(){
        return courseService.getAllCourses();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

}
