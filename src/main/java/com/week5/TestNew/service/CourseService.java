package com.week5.TestNew.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week5.TestNew.model.Course;
import com.week5.TestNew.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void addCourse(Course course) {
        Course newCourse = new Course();
        newCourse.setID(course.getID());
        newCourse.setTitle(course.getTitle());
        newCourse.setDescription(course.getDescription());
        newCourse.setDuration(course.getDuration());
        courseRepository.save(newCourse);
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String Id) {
        return courseRepository.findById(Id).get();
    }

    public String updateCourse(Course course, String Id) {
        if(courseRepository.findById(Id).isPresent()){
            Course newCourse = courseRepository.findById(Id).get();
            newCourse.setDescription(course.getDescription());
            newCourse.setDuration(course.getDuration());
            newCourse.setStudentList(course.getStudentList());
            newCourse.setTitle(course.getTitle());
            courseRepository.save(newCourse);
            return "Given Course is updated";
        }
        return "ID not found";
    }

    public String deleteCourseById(String Id) {
        courseRepository.deleteById(Id);
        return "Delete course having ID: "+Id;
    }
    
}
