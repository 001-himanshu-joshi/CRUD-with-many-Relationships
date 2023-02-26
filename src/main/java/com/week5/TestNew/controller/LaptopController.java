package com.week5.TestNew.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.week5.TestNew.model.Laptop;
import com.week5.TestNew.repository.StudentRepository;
import com.week5.TestNew.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/saveLaptop")
    public Laptop saveLaptop(@RequestBody String laptop) {
        Laptop newlaptop = setLaptop(laptop);
        return laptopService.addLaptop(newlaptop);
    }

    private Laptop setLaptop(String laptop) {
        JSONObject json = new JSONObject(laptop);
        Laptop newLaptop = new Laptop();
        newLaptop.setID(json.getString("ID"));
        newLaptop.setName(json.getString("name"));
        newLaptop.setBrand(json.getString("brand"));
        newLaptop.setPrice(json.getInt("price"));
        String student = json.getString("studentID");
        newLaptop.setStudent(studentRepository.findById(student).get());
        return newLaptop;
    }

    @GetMapping("/getLaptop")
    public List<Laptop> getAllLaptop() {
        return laptopService.getAllLaptop();
    }

    @GetMapping("/getLaptopById/{Id}")
    public Laptop getLaptopById(@PathVariable String Id) {
        return laptopService.getLaptopById(Id);
    }

    @PutMapping("/updateLaptop/{Id}")
    public String updateLaptop(@RequestBody Laptop laptop, @PathVariable String Id){
        return laptopService.updateLaptop(laptop, Id);
    }
    @DeleteMapping("/deleteLaptopById/{Id}")
    public String deleteLaptopById(@PathVariable String Id) {
        return laptopService.deleteLaptopById(Id);
    }
}
