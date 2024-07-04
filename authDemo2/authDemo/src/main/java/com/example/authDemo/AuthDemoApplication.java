package com.example.authDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class AuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthDemoApplication.class, args);
	}

}
