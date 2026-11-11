package com.spring.spring_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Method to handle student not found exception.
     * @param e
     * @return
     */
    public ResponseEntity<StudentErrorResponse> handlException(
        StudentNotFoundException e) {

            StudentErrorResponse err = new StudentErrorResponse();

            err.setStatus(HttpStatus.NOT_FOUND.value());
            err.setMessage(e.getMessage());
            err.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handlException(Exception e) {
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
