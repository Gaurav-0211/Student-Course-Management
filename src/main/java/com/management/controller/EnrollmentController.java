package com.management.controller;

import com.management.dto.EnrollmentDto;
import com.management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public EnrollmentDto enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            @RequestParam(defaultValue = "Active") String status) {
        return enrollmentService.enrollStudent(studentId, courseId, status);
    }

    @GetMapping("/student/{studentId}")
    public List<EnrollmentDto> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<EnrollmentDto> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }

    @DeleteMapping("/{enrollmentId}")
    public void deleteEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
    }
}