package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

/**
 * 
 * StudentService
 */
public interface StudentService {
    StudentDto createStudent(StudentDto studDto);

    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long id, StudentDto studDto);

    StudentDto patchStudent(Long id, StudentDto studDto);

    void deleteStudentById(Long id);
}
