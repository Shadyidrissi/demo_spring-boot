package com.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.modules.Student;
import com.test.demo.service.StudService;

@RestController
@RequestMapping("/student")
public class StudContro {
     
    @Autowired
    private StudService studService;

    @RequestMapping("/get_student")
    public Student getUser(@RequestParam Integer id){
        return studService.getUser(id);
    }
}
