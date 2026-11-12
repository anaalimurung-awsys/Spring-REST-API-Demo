package com.spring.spring_rest.service;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

@Service 
public class StudentServiceImpl implements StudentService {

    private StudentRepository studRepo;

    public StudentServiceImpl(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    
    @Override
    public StudentDto createStudent(StudentDto studDto) {
        // converting StudentDto to Student entity
        Student stud = StudentMapper.mapToStudent(studDto);
        Student saved = studRepo.save(stud);

        // Student is converted back to StudentDto
        return StudentMapper.mapToStudentDto(saved);
    }


    public StudentRepository getStudRepo() {
        return studRepo;
    }


    public void setStudRepo(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    
}
