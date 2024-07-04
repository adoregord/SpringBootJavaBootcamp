package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    
    // @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }   

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthorById(id);
        return "Author dengan ID " + id + " berhasil dihapus";
    }
}
