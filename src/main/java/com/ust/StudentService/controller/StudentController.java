package com.ust.StudentService.controller;

import com.ust.StudentService.model.Student;
import com.ust.StudentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getAllStudents/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/editStudent/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable("id") int id, @RequestBody Student studentDetails){
        return new ResponseEntity<>(service.editStudent(id, studentDetails), HttpStatus.OK);
    }
}
