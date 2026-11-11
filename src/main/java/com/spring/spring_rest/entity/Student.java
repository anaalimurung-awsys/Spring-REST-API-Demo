package com.spring.spring_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name="student")
public class Student {
    private String firstName;
    private String lastName;

    public Student() {
    }
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    
}
