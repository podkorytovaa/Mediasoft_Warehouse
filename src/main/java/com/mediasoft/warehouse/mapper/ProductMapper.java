package com.mediasoft.warehouse.mapper;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.model.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity(),
                product.getDateChange(),
                product.getDateCreate()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getCategory(),
                productDto.getPrice(),
                productDto.getQuantity(),
                productDto.getDateChange(),
                productDto.getDateCreate()
        );
    }

}
