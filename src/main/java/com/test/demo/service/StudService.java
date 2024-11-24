package com.test.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.modules.Student;
import com.test.demo.repository.StudResp;

import jakarta.persistence.Id;

@Service
public class StudService {
    @Autowired
    private StudResp studResp;

    public Student getUser(Integer id) {
        // Fetch the student by ID (assuming 1 for the example).
        Optional<Student> stude = this.studResp.findById(id);
        // Return the student if present, otherwise return null.
        return stude.orElse(null);  
    }
    public List<Student> getAllUser() {
        // Fetch the student by ID (assuming 1 for the example).
    	return this.studResp.findAll();
           
    }
}
