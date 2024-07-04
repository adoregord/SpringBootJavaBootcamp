package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getItem() {
        return bookService.getItem();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping("/title/{bookTitle}")
    public Optional<Book> findByTitle(@PathVariable String bookTitle) {
        return bookService.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Optional<Book> findOne(@PathVariable long id) {
        return bookService.findOne(id);
        
    }

    // @GetMapping("/author/{author}")
    // public List<Book> findByAuthor(@PathVariable String author) {
    //     return bookService.findByAuthor(author);
    // }

    @PutMapping("title/{bookTitle}")
    public Book updateTitle(@PathVariable String bookTitle, @RequestBody Book book) {
        return bookService.updateTitle(bookTitle, book);
    }
    
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "book id: " + id +" is deleted";
    }

}