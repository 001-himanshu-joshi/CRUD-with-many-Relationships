package com.week5.TestNew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week5.TestNew.model.Book;
import com.week5.TestNew.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }
    
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(String id){
        return bookRepository.findById(id).get();
    }

    public String deleteBookById(String id){
        bookRepository.deleteById(id);
        return "Deleted the book with Id: "+ id;
    }

    public String updateBook(Book book, String Id){
        if(bookRepository.findById(Id).isPresent()){
            Book newBook = bookRepository.findById(Id).get();
            newBook.setAuthor(book.getAuthor());
            newBook.setTitle(book.getTitle());
            newBook.setPrice(book.getPrice());
            newBook.setStudent(book.getStudent());
            newBook.setDescription(book.getDescription());
            bookRepository.save(newBook);
            return "Given Book is updated";
        }
        return "Id Not found";
    }
}
