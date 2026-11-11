package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController 
@RequestMapping ("/api")
public class StudentRestController {
    
    private List<Student> studs;

    @PostConstruct 
    public void initialize() {
        studs = new ArrayList<>();
        
        // studs.add(new Student("Juuzou", "Suzuya"));
        // studs.add(new Student("Muichirou", "Tokitou"));
        // studs.add(new Student("Yuichirou", "Tokitou"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studs;
    }

    /**
     * For path variables.
     * @param id
     * @return
     */
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        
        if(id >= studs.size() || id < 0) 
            throw new StudentNotFoundException("Student id " + id + 
                                                " not found!");

        return studs.get(id);
    }
}
