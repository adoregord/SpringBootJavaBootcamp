package com.example.sqql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqql.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPrice(double price, org.springframework.data.domain.Pageable pageable);
}
