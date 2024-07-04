package com.example.intercept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intercept.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
