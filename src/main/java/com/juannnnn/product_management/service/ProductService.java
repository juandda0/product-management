package com.juannnnn.product_management.service;

import com.juannnnn.product_management.exceptions.ResourceNotFoundException;
import com.juannnnn.product_management.model.Product;
import com.juannnnn.product_management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll(String keyWord) {

        if(keyWord != null){
            return productRepository.findAll(keyWord);
        }

        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }

    public void editProuct(Long id) {
    }

}
