package com.week5.TestNew.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.week5.TestNew.model.Book;
import com.week5.TestNew.repository.StudentRepository;
import com.week5.TestNew.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/saveBook")
    public void saveBook(@RequestBody String book) {
        Book newbook = setBook(book);
        bookService.addBook(newbook);
    }

    private Book setBook(String book) {
        JSONObject json = new JSONObject(book);
        Book newBook = new Book();
        newBook.setID(json.getString("ID"));
        newBook.setAuthor(json.getString("author"));
        newBook.setDescription(json.getString("description"));
        newBook.setPrice(json.getString("price"));
        newBook.setTitle(json.getString("title"));
        String student = json.getString("studentID");
        newBook.setStudent(studentRepository.findById(student).get());
        return newBook;

    }
    @GetMapping("/getBook")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{Id}")
    public Book getBookById(@PathVariable String Id) {
        return bookService.getBookById(Id);
    }

    @PutMapping("/updateBook/{Id}")
    public String updateBook(@RequestBody Book book, @PathVariable String Id){
        return bookService.updateBook(book, Id);
    }
    @DeleteMapping("/deleteBookById/{Id}")
    public String deleteBookById(@PathVariable String Id) {
        return bookService.deleteBookById(Id);
    }
}
