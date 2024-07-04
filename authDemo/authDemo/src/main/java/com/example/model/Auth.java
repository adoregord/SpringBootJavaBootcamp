package com.example.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;



@Entity
@Data
@Table(name="auth", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Auth {
    
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @PrePersist
    public void generateUUID() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}
