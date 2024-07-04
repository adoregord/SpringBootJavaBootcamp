package com.example.demo.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

@Entity
@Data
public class Book{
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NonNull
    private String title;

    @NonNull
    private String author;
    // @ManyToOne(fetch=FetchType.LAZY)
    // @JoinColumn(name = "author.id", referencedColumnName = "id")
    // private Author author;
}



// public class Book {
    // public Book(String title, String author) {
    //     this.title = title;
    //     this.author = author;
    // }
    // public Book(){}

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private long id;

    // @Column(nullable = false, unique = true)
    // private String title;

    // @Column(nullable = false)
    // private String author;

    

// }
