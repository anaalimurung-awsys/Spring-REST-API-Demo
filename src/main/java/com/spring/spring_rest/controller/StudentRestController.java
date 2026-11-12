package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
// import com.spring.spring_rest.entity.Student;
// import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;

// import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {
    
    private StudentService studService;

    public StudentRestController(StudentService studService) {
        this.studService = studService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudents(@RequestBody StudentDto studDto) {
        StudentDto saved = studService.createStudent(studDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
}
