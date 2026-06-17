package com.util.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.UuidGenerator;


import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "code", nullable = false, unique = true)
    @Pattern(regexp="^\\d{10}$", message = "Code must be exactly 10 digits")
    private String code;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    //Constructor
    public Product(){
        super();
    }

    //Constructor Overriding
    public Product(String code, String desc, BigDecimal price){
        super();
        this.code = code;
        this.description = desc;
        this.price = price;
    }

    public Product(String code, BigDecimal price){
        super();
        this.code = code;
        this.price = price;
    }

    //Getters
    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @PrePersist
    @PreUpdate
    private void normalizeCode(){
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code cannot be null or blank");
        }

        code = code.trim();

        if (!code.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("Code must be exactly 10 digits");
        }

        code = String.format("%010d", Long.parseLong(code));
    }
};
