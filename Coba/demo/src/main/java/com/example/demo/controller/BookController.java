package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Optional<Book> findOne(@PathVariable long id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        Book newbook = new Book(book.getTitle(),book.getAuthor());
//        Book book1 = bookRepository.save(newbook);
//        return book1;
        return bookRepository.save(newbook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        return bookRepository.save(book);
    }
}