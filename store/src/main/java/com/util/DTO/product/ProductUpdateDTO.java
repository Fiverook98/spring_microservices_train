package com.util.DTO.product;

import java.math.BigDecimal;

public class ProductUpdateDTO {
    private String code;
    private BigDecimal price;

    public ProductUpdateDTO() {
        super();
    }

    public ProductUpdateDTO(String code, BigDecimal price) {
        super();
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
