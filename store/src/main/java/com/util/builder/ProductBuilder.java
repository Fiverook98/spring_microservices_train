package com.util.builder;

import com.util.DTO.product.ProductCreateDTO;
import com.util.DTO.product.ProductDTO;
import com.util.DTO.product.ProductSummaryDTO;
import com.util.entity.Product;

public class ProductBuilder {
    public static Product fromDTOtoEntity(ProductCreateDTO dto){
        return new Product(
                dto.getCode(),
                dto.getDescription(),
                dto.getPrice()
        );
    }

    public static ProductDTO fromEntityToDTO(Product entity){
        return new ProductDTO(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getPrice()
        );
    }

    public static ProductSummaryDTO fromEntityToSummaryDTO(Product entity){
        return new ProductSummaryDTO(
                entity.getCode(),
                entity.getDescription()
        );
    }


}
