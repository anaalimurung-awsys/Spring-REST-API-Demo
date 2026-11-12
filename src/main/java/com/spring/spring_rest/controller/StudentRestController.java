package com.spring.spring_rest.controller;

import com.spring.spring_rest.dto.StudentDto;
// import com.spring.spring_rest.entity.Student;
// import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;
// import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handles the operations via paths
 * StudentRestController
 */
@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {
    
    private StudentService studService;

    public StudentRestController(StudentService studService) {
        this.studService = studService;
    }

    /**
     * Method to store data to the database via Postman
     * @param studDto
     * @return
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudents(@Valid @RequestBody StudentDto studDto) {
        StudentDto saved = studService.createStudent(studDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    /**
     * Method to get data by id.
     * @param id
     * @return
     */
    @GetMapping ("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        StudentDto studDto = studService.getStudentById(id);

        return ResponseEntity.ok(studDto);
    }

    /**
     * Method to get all the students in the database.
     * @return
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studs = studService.getAllStudents();

        return ResponseEntity.ok(studs);
    }

    /**
     * Method to update data via id and entity.
     * @param id
     * @param studDto
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                            @Valid @RequestBody StudentDto studDto) {
        StudentDto stud = studService.updateStudent(id, studDto);
        return ResponseEntity.ok(stud);
    }

    /**
     * Method to modify specified parts of the data from the database.
     * @param id
     * @param studDto
     * @return
     */
    @PatchMapping ("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
                            @Valid @RequestBody StudentDto studDto) {
        StudentDto stud = studService.patchStudent(id, studDto);
        
        return ResponseEntity.ok(stud);
    }

    /**
     * Method to delete data by id.
     * @param id
     * @return
     */
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studService.deleteStudentById(id);

        return ResponseEntity.ok("Student data deleted successfully");
    }

    // @PostConstruct 
    // public void initialize() {
    //     studs = new ArrayList<>();
        
    //     // studs.add(new Student("Juuzou", "Suzuya"));
    //     // studs.add(new Student("Muichirou", "Tokitou"));
    //     // studs.add(new Student("Yuichirou", "Tokitou"));
    // }

    // @GetMapping("/students")
    // public List<Student> getStudents() {
    //     return studs;
    // }

    // /**
    //  * For path variables.
    //  * @param id
    //  * @return
    //  */
    // @GetMapping("/students/{id}")
    // public Student getStudent(@PathVariable int id) {
        
    //     if(id >= studs.size() || id < 0) 
    //         throw new StudentNotFoundException("Student id " + id + 
    //                                             " not found!");

    //     return studs.get(id);
    // }
}
