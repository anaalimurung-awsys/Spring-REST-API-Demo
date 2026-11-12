package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * 
 * StudentMapper
 */
public class StudentMapper {
    /**
     * Method that will map Student to StudentDto
     * @param stud
     * @return
     */
    public static StudentDto mapToStudentDto(Student stud) {
        return new StudentDto(stud.getId(), 
                                stud.getFirstName(), 
                                stud.getLastName(), 
                                stud.getEmail());
    }

    /**
     * Method that will map StudentDto to Student
     * @param studDto
     * @return
     */
    public static Student mapToStudent(StudentDto studDto) {
        return new Student(studDto.getId(),
                            studDto.getFirstName(),
                            studDto.getLastName(),
                            studDto.getEmail());
    }
}
