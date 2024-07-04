package com.example.sqql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sqql.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.name = ?1 and u.email = ?2")
    List<User> findUserUsingQuery(String name, String email);

    @Query(value = "SELECT * FROM Users u WHERE u.name = ?1 and u.email = ?2", nativeQuery = true)
    List<User> findUserUsingNativeQuery(String name, String email);

    @Query(value = "SELECT * FROM Users u WHERE u.email like %?1%", nativeQuery = true)
    List<User> findUserUsingNativeQueryLike(String email);
    
    @Query("SELECT u FROM User u")
    List<User> findAllUsers(Sort sort);
}
