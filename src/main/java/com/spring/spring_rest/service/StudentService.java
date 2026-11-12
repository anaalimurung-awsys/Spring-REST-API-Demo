package com.spring.spring_rest.service;

import com.spring.spring_rest.dto.StudentDto;
import java.util.List;

/**
 * This is an interface.
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
