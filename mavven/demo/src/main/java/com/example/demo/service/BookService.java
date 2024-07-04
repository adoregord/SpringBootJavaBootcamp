package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    // @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getItem(){
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        // if(book.getAuthor() != null){
        //     System.out.println(book);
        //     authorRepository.findById(book.getAuthor().getId());
        // }
        return bookRepository.save(book);
    }

    public Optional<Book> findOne(long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    // public List<Book> findByAuthor(Author author) {
    //     return bookRepository.findByAuthor(author);
    // }

    public Book updateTitle(String bookTitle, Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id){
        bookRepository.deleteById(id);  
    }
}
