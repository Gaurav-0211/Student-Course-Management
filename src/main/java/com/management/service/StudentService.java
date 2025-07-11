package com.management.service;

import com.management.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    void deleteStudent(Long id);
}
