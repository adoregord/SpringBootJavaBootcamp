package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Entity
@Data
@Table(name = "Author", uniqueConstraints= {@UniqueConstraint(columnNames={"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "book"})
public class Author{
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NonNull
    private String first_name;

    @NonNull
    private String last_name;

    @OneToMany(mappedBy = "author")
    private List<Book> book;

    // public long getId() {
    //     return id;
    // }

}

// public class author {
//     public author(String first_name, String last_name){
//         this.first_name = first_name;
//         this.last_name = last_name;
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//         private int id;
    
//     @Column(nullable = false, unique = false)
//         private String first_name;

//     @Column(nullable = false)
//         private String last_name;
    
//     @OneToOne(fetch = FetchType.EAGER);
//     @JoinColumn(name = "Book.id");
//     private Book book;

//     private String author;
// }
