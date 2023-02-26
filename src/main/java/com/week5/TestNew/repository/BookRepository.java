package com.week5.TestNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week5.TestNew.model.Book;

public interface BookRepository extends JpaRepository<Book, String>{
    
}
