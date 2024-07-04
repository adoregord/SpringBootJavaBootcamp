package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    // public Optional<Book> findByTitle(String bookTitle);
    List<Book> findByTitle(String title);
    // public List<Book> findByAuthor(Author author);
    // List<Book> findByTitle(String title);
}

