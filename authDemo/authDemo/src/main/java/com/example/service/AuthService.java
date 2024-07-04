package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Auth;
import com.example.repository.AuthRepository;

@Service
public class AuthService {
    
    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;


    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Auth create(Auth auth){
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        return authRepository.save(auth);
    }

    public ResponseEntity<?> loginUser(String username, String password) {
        Auth auth = authRepository.findByUsername(username);
        if(auth != null &&  passwordEncoder.matches(password, auth.getPassword())){
            return ResponseEntity.ok("Logged in");
        }
        else{
            return ResponseEntity.status(401).body("Username or Password is invalid");
        }
    }
}


