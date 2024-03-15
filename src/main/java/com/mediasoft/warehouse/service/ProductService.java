package com.mediasoft.warehouse.service;

import com.mediasoft.warehouse.dto.ProductDto;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс сервиса для работы с товарами.
 */
public interface ProductService {
    /**
     * Метод для создания нового товара.
     *
     * @param productDto объект ProductDto, содержащий информацию о товаре.
     * @return ProductDto, созданный товар.
     */
    ProductDto createProduct(ProductDto productDto);

    /**
     * Метод для получения товара по UUID.
     *
     * @param productId идентификатор товара.
     * @return ProductDto, найденный товар.
     */
    ProductDto getProductById(UUID productId);

    /**
     * Метод для получения всех товаров.
     *
     * @return список объектов ProductDto, представляющих все товары.
     */
    List<ProductDto> getAllProducts();

    /**
     * Метод для редактирования информации о товаре.
     *
     * @param productId     идентификатор товара, который нужно обновить.
     * @param updateProduct объект ProductDto, содержащий обновленную информацию о товаре.
     * @return ProductDto, обновленный товар.
     */
    ProductDto updateProduct(UUID productId, ProductDto updateProduct);

    /**
     * Метод для удаления товара по UUID.
     *
     * @param productId идентификатор товара, который нужно удалить.
     */
    void deleteProduct(UUID productId);

    /**
     * Метод для удаления всех товаров.
     */
    void deleteAllProducts();
}
