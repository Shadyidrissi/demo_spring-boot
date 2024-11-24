package com.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.modules.Student;
import com.test.demo.service.StudService;

@RestController
@RequestMapping("/student")
public class StudContro {
     
    @Autowired
    private StudService studService;

    @GetMapping("/get_student/{id}")
    public Student getUser(@PathVariable Integer id){
        return studService.getUser(id);
    }
    
    @GetMapping("/get_all_student")
    public List<Student> getAllUser(){
        return studService.getAllUser();
    }
}
