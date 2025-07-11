package com.management.service;

import com.management.dto.EnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDto enrollStudent(Long studentId, Long courseId, String status);
    List<EnrollmentDto> getEnrollmentsByStudent(Long studentId);
    List<EnrollmentDto> getEnrollmentsByCourse(Long courseId);
    void deleteEnrollment(Long enrollmentId);
}
