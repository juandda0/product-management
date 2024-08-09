package com.juannnnn.product_management.controller;

import com.juannnnn.product_management.model.Product;
import com.juannnnn.product_management.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public String homePage(Model model, @Param("keyWord") String keyWord){

        List<Product> productList = productService.listAll(keyWord);

        model.addAttribute("productList", productList);
        model.addAttribute("keyWord", keyWord);

        return "index";
    }

    @GetMapping("/new")
    public String registProduct(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        return "new-product";
    }

    @PostMapping("save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-product");

        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
