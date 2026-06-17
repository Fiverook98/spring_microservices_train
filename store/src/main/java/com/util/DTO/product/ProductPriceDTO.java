package com.util.DTO.product;

import java.math.BigDecimal;

public class ProductPriceDTO {
    private String description;
    private BigDecimal price;

    public ProductPriceDTO() {
        super();
    }

    public ProductPriceDTO(String desc, BigDecimal price){
        super();
        this.description = desc;
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
