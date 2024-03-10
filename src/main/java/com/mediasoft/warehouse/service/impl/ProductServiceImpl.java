package com.mediasoft.warehouse.service.impl;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.exception.ProductNotFoundException;
import com.mediasoft.warehouse.mapper.ProductMapper;
import com.mediasoft.warehouse.model.Product;
import com.mediasoft.warehouse.repository.ProductRepository;
import com.mediasoft.warehouse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product saveProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(saveProduct);
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(String.format("Товар с артикулом %s не найден", productId)));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(UUID productId, ProductDto updateProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException(String.format("Товар с артикулом %s не найден", productId))
        );

        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setCategory(updateProduct.getCategory());
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        product.setDateChange(updateProduct.getDateChange());
        product.setDateCreate(updateProduct.getDateCreate());

        Product updateProductObj = productRepository.save(product);

        return ProductMapper.mapToProductDto(updateProductObj);
    }

    @Override
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException(String.format("Товар с артикулом %s не найден", productId))
        );

        productRepository.deleteById(productId);
    }
}
