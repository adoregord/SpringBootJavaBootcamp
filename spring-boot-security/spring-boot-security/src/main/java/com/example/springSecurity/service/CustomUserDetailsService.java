package com.example.springSecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
             UserDetails user = User.withUsername("admin".toString())
                    .password(new BCryptPasswordEncoder().encode("admin"))
                    .roles("ADMIN")
                    .build();
             return user;
        } else if (username.equals("user".toString())) {
            UserDetails user = User.withUsername("user")
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .roles("USER")
                    .build();
             return user;
        } else if (username.equals("moderator".toString())) {
            UserDetails user = User.withUsername("moderator")
                    .password(new BCryptPasswordEncoder().encode("moderator"))
                    .roles("MODERATOR")
                    .build();
             return user;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}