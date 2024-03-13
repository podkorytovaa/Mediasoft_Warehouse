package com.mediasoft.warehouse.service.impl;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.exception.ProductNotFoundException;
import com.mediasoft.warehouse.mapper.ProductMapper;
import com.mediasoft.warehouse.model.Product;
import com.mediasoft.warehouse.repository.ProductRepository;
import com.mediasoft.warehouse.service.ProductService;
import com.mediasoft.warehouse.util.validation.ValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private final ValidatorUtil validatorUtil;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        product.setDateCreate(new Date());
        product.setDateChange(new Date());
        validatorUtil.validate(product);
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

        if(updateProduct.getName() != null) {
            product.setName(updateProduct.getName());
        }
        if(updateProduct.getDescription() != null) {
            product.setDescription(updateProduct.getDescription());
        }
        if(updateProduct.getCategory() != null) {
            product.setCategory(updateProduct.getCategory());
        }
        if(updateProduct.getPrice() != null) {
            product.setPrice(updateProduct.getPrice());
        }
        if (product.getQuantity() != updateProduct.getQuantity()) {
            product.setDateChange(new Date());
        }
        if(updateProduct.getQuantity() != null) {
            product.setQuantity(updateProduct.getQuantity());
        }

        validatorUtil.validate(product);

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

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
