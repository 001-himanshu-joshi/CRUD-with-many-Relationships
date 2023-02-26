package com.week5.TestNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week5.TestNew.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
    
}
