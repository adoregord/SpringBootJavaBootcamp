package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.model.Auth;
import com.example.service.AuthService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/register")
    public Auth addUser(@RequestBody Auth auth) {
        return authService.create(auth);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
    }

}
