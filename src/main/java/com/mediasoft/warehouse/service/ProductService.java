package com.mediasoft.warehouse.service;

import com.mediasoft.warehouse.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(UUID productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(UUID productId, ProductDto updateProduct);

    void deleteProduct(UUID productId);

    void deleteAllProducts();
}
