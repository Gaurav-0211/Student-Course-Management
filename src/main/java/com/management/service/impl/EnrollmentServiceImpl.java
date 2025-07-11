package com.management.service.impl;

import com.management.dto.EnrollmentDto;
import com.management.entity.Course;
import com.management.entity.Enrollment;
import com.management.entity.Student;
import com.management.repo.CourseRepository;
import com.management.repo.EnrollmentRepository;
import com.management.repo.StudentRepository;
import com.management.service.EnrollmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnrollmentDto enrollStudent(Long studentId, Long courseId, String status) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .status(status)
                .enrolledOn(LocalDate.now())
                .build();

        Enrollment saved = enrollmentRepository.save(enrollment);
        return modelMapper.map(saved, EnrollmentDto.class);
    }

    @Override
    public List<EnrollmentDto> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudent_Id(studentId)
                .stream()
                .map(e -> modelMapper.map(e, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDto> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourse_Id(courseId)
                .stream()
                .map(e -> modelMapper.map(e, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
