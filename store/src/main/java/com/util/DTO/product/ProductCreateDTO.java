package com.util.DTO.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductCreateDTO {

    private UUID id;

    @NotBlank(message = "Code cannot be blank")
    private String code;

    private String description;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    // Constructor

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String code, String description, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public ProductCreateDTO(String code, BigDecimal price){
        this.code = code;
        this.price = price;
    }

    // Getter

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // Setter
    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
