package com.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.demo.modules.Student;
import com.test.demo.repository.StudResp;
import com.test.demo.service.StudService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudContro {

    @Autowired
    private StudService studService;
    @Autowired
    private StudResp studResp;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studService.getUser(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studService.getAllUser();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student studentObj = studService.saveStudent(student);
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studService.updateStudent(student), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
    	studService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<Student> deleteAllStudent() {
    	studService.deleteAllStudent();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
