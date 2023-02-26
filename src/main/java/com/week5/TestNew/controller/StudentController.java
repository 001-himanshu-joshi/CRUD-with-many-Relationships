package com.week5.TestNew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.week5.TestNew.model.Student;
import com.week5.TestNew.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    
    @PostMapping("/saveStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentById/{Id}")
    public Student getStudentById(@PathVariable String Id){
        return studentService.getStudentById(Id);
    }

    @PutMapping("/updateStudent/{Id}")
    public String updateStudent(@RequestBody Student student, @PathVariable String Id){
        return studentService.updateStudent(student, Id);
    }
    @DeleteMapping("/delete/Student/{Id}")
    public String deleteStudentById(@PathVariable String Id){
        return studentService.deleteStudentById(Id);
    }
}
