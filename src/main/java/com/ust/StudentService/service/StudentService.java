package com.ust.StudentService.service;

import com.ust.StudentService.model.Student;
import com.ust.StudentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;
    public Student addStudent(Student student) {
        return repo.save(student);
    }


    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Strudent not found"));
    }

    public Student editStudent(int id, Student student) {
        Student stu=repo.findById(id).get();
        stu.setName(student.getName());
        stu.setStd(student.getStd());
        stu.setSection(student.getSection());
        stu.setTotalMarks(student.getTotalMarks());

        return repo.save(stu);
    }
}
