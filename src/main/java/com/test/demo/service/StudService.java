package com.test.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.modules.Student;
import com.test.demo.repository.StudResp;

import jakarta.validation.Valid;

@Service
public class StudService {

    @Autowired
    private StudResp studResp;

    // Get a single student by ID
    public Student getUser(Integer id) {
        Optional<Student> student = studResp.findById(id);
        return student.orElse(null); // Return the student or null if not found
    }

    // Get all students
    public List<Student> getAllUser() {
        return studResp.findAll(); // Fetch all student records
    }

    // Save or update a student
    public Student updateStudent(Student student) {
        return studResp.save(student); // Save and return the student record
    }

    // Add a new student
    public Student saveStudent(Student student) {
        return studResp.save(student);
    }
    
    // Delete a single student by ID
    public void deleteStudent(Integer id) {
         studResp.deleteById(id);
    }
}
