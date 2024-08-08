package com.juannnnn.product_management.repository;

import com.juannnnn.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
