package com.juannnnn.product_management.controller;

import com.juannnnn.product_management.model.Product;
import com.juannnnn.product_management.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/")
    public String homePage(Model model){

        List<Product> productList = productService.lisAll();
        model.addAttribute("productList", productList);

        return "index";
    }

    @RequestMapping("/new")
    public String registProduct(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        return "newProduct";
    }
}
