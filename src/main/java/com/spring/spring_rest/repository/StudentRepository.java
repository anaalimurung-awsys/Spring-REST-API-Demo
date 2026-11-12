package com.spring.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_rest.entity.Student;

/**
 * 
 * StudentRepository
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
