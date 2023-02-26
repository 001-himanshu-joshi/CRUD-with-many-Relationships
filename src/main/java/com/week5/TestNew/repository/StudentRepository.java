package com.week5.TestNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week5.TestNew.model.Student;


public interface StudentRepository extends JpaRepository<Student, String> {
    
}
