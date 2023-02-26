package com.week5.TestNew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.week5.TestNew.model.Course;
import com.week5.TestNew.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
 
    @Autowired
    CourseService courseService;
    
    @PostMapping("/saveCourse")
    public void saveCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @GetMapping("/getCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/getCourseById/{Id}")
    public Course getCourseById(@PathVariable String Id){
        return courseService.getCourseById(Id);
    }

    @PutMapping("/updateCourse/{Id}")
    public String updateCourse(@RequestBody Course course, @PathVariable String Id){
        return courseService.updateCourse(course, Id);
    }

    @DeleteMapping("/deleteCourseById/{Id}")
    public String deleteCourseById(@PathVariable String Id){
        return courseService.deleteCourseById(Id);
    }
}
