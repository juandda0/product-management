package com.juannnnn.product_management.repository;

import com.juannnnn.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE"
        + " CONCAT(p.name, p.brand)"
        + " LIKE %?1%")
    public List<Product> findAll(String keyWord);

}
