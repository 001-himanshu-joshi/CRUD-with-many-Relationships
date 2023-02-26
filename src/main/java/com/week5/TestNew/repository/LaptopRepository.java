package com.week5.TestNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week5.TestNew.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, String> {
    
}
