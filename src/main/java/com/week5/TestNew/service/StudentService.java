package com.week5.TestNew.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week5.TestNew.model.Student;
import com.week5.TestNew.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student addStudent(Student student) {

        Student newStudent = new Student();
        newStudent.setStudentID((student.getStudentID()));
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        newStudent.setPhoneNumber(student.getPhoneNumber());
        newStudent.setBranch(student.getBranch());
        newStudent.setDepartment(student.getDepartment());
        newStudent.setAddress(student.getAddress());
        return studentRepository.save(newStudent);
    }

    public Student getStudentById(String Id) {
        return studentRepository.findById(Id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String updateStudent(Student student , String Id){
        if(studentRepository.findById(Id).isPresent()){
            Student newStud = getStudentById(Id);
            newStud.setAddress(student.getAddress());
            newStud.setAge(student.getAge());
            newStud.setBranch(student.getBranch());
            newStud.setDepartment(student.getDepartment());
            newStud.setName(student.getName());
            newStud.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(newStud);
            return "Given Student is updated";
        }
        return "Id not found";
    }
    public String deleteStudentById(String Id) {
        studentRepository.deleteById(Id);
        return "Deleted the student with Id : "+Id;
    }
    
}
