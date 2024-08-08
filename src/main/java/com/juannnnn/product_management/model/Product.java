package com.juannnnn.product_management.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 40)
    private String brand;

    @Column(nullable = false, length = 50)
    private String madeIn;

    @Column(nullable = false)
    private float price;

    public Product(){
    }

    public Product(Long id, String name, String brand, String madeIn, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrecio(float price) {
        this.price = price;
    }

}
