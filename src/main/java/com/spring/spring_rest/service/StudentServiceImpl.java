package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

@Service 
public class StudentServiceImpl implements StudentService {

    private StudentRepository studRepo;

    public StudentServiceImpl(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public StudentRepository getStudRepo() {
        return studRepo;
    }
    
    public void setStudRepo(StudentRepository studRepo) {
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

    @Override
    public StudentDto getStudentById(Long id) {
       Student stud = studRepo.findById(id).
                        orElseThrow(() -> 
                        new StudentNotFoundException("Student " 
                            + id + " not found."));
        
        return StudentMapper.mapToStudentDto(stud);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studs = studRepo.findAll();

        return studs.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student)).
            collect(Collectors.toList());
    }
    
    
}
