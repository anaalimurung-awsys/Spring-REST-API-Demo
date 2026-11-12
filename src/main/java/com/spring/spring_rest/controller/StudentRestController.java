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
import com.spring.spring_rest.entity.Student;
// import com.spring.spring_rest.entity.Student;
// import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

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

    /**
     * 
     * @param studDto
     * @return
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudents(@Valid @RequestBody StudentDto studDto) {
        StudentDto saved = studService.createStudent(studDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    /**
     * 
     * @param id
     * @return
     */
    @GetMapping ("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        StudentDto studDto = studService.getStudentById(id);

        return ResponseEntity.ok(studDto);
    }

    /**
     * 
     * @return
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studs = studService.getAllStudents();

        return ResponseEntity.ok(studs);
    }
}
