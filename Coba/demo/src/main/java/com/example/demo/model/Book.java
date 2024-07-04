package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

}
