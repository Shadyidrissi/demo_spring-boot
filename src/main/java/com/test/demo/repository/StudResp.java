package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.modules.Student;

public interface  StudResp extends JpaRepository<Student, Integer>{
    
}
