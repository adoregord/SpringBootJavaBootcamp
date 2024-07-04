package com.example.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    // @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(long id) {
        authorRepository.deleteById(id);
    }
}

