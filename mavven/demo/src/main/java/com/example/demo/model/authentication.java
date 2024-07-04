package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class authentication {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique= true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}
