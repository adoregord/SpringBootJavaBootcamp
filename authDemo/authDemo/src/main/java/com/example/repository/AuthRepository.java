package com.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Auth;


public interface AuthRepository extends JpaRepository<Auth, UUID> {
    Auth findByUsername(String username);
}
