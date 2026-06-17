package com.util.DTO.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {

    private UUID id;

    @NotBlank(message = "Code cannot be blank")
    private String code;

    private String description;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    // Constructor

    public ProductDTO() {
        super();
    }

    public ProductDTO(UUID id, String code, String description, BigDecimal price) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public ProductDTO(String code, BigDecimal price){
        super();
        this.code = code;
        this.price = price;
    }

    // Getter
    public UUID getId() {
        return id;
    }

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
    public void setId(UUID id) {
        this.id = id;
    }

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
