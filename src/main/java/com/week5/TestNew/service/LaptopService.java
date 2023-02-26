package com.week5.TestNew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week5.TestNew.model.Laptop;
import com.week5.TestNew.repository.LaptopRepository;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    StudentService studentService;

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(String Id) {
        return laptopRepository.findById(Id).get();
    }

    public String updateLaptop(Laptop laptop, String Id){
        if(laptopRepository.findById(Id).isPresent()){
            Laptop newLap = laptopRepository.findById(Id).get();
            newLap.setBrand(laptop.getBrand());
            newLap.setName(laptop.getName());
            newLap.setPrice(laptop.getPrice());
            newLap.setStudent(laptop.getStudent());
            laptopRepository.save(newLap);
            return "Given Laptop is updated";
        }
        return "ID not found";
    }
    public String deleteLaptopById(String Id) {
        laptopRepository.deleteById(Id);
        return "Deleted Laptop with ID "+Id;
    }
    
}
