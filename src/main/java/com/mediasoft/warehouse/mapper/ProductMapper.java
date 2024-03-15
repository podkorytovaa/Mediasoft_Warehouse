package com.mediasoft.warehouse.mapper;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.model.Product;

/**
 * Класс, используемый для преобразования <b>Product</b> и <b>ProductDto</b>.
 */
public class ProductMapper {

    /**
     * Метод выполняет преобразование объекта <b>Product</b> в объект <b>ProductDto</b>.
     *
     * @param product объект Product, который нужно преобразовать.
     * @return объект ProductDto, полученный в результате преобразования.
     */
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

    /**
     * Метод выполняет преобразование объекта <b>ProductDto</b> в объект <b>Product</b>.
     *
     * @param productDto объект ProductDto, который нужно преобразовать.
     * @return объект Product, полученный в результате преобразования.
     */
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
