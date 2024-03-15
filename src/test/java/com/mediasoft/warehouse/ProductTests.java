package com.mediasoft.warehouse;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.exception.ProductNotFoundException;
import com.mediasoft.warehouse.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Класс, содержащий unit-тесты для <b>ProductService</b>.
 */
@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductService productService;

    /**
     * Метод, который выполняется перед каждым тестом и удаляет все продукты из базы данных.
     */
    @BeforeEach
    void setUp() {
        productService.deleteAllProducts();
    }

    /**
     * Тест для метода createProduct.
     */
    @Test
    void testCreateProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setName("Стул");
        productDto.setDescription("Описание стула");
        productDto.setCategory("Мебель");
        productDto.setPrice(BigDecimal.valueOf(10000));
        productDto.setQuantity(10);

        productDto = productService.createProduct(productDto);

        Assertions.assertNotNull(productDto.getId());
    }

    /**
     * Тест для метода getProductById.
     */
    @Test
    void testGetProductById() {
        String name = "Стол";
        String description = "Описание стола";
        String category = "Мебель";
        BigDecimal price = BigDecimal.valueOf(5000);
        Integer quantity = 5;

        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setDescription(description);
        productDto.setCategory(category);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);

        productDto = productService.createProduct(productDto);
        ProductDto findProduct = productService.getProductById(productDto.getId());

        Assertions.assertEquals(name, findProduct.getName());
        Assertions.assertEquals(description, findProduct.getDescription());
        Assertions.assertEquals(category, findProduct.getCategory());
        Assertions.assertEquals(quantity, findProduct.getQuantity());
    }

    /**
     * Тест для проверки обработки исключения ProductNotFoundException.
     */
    @Test
    void testNotFoundProduct() {
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.getProductById(UUID.randomUUID()));
    }

    /**
     * Тест для метода updateProduct.
     */
    @Test
    void testUpdateProduct() {
        ProductDto product = new ProductDto();
        product.setName("Стол");
        product.setDescription("Описание стола");
        product.setCategory("Мебель");
        product.setPrice(BigDecimal.valueOf(5000));
        product.setQuantity(5);
        product = productService.createProduct(product);

        String name = "Стул";
        String description = "Описание стула";
        Integer quantity = 10;
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setDescription(description);
        productDto.setQuantity(quantity);
        productService.updateProduct(product.getId(), productDto);

        var pr = productService.getProductById(product.getId());
        Assertions.assertEquals(name, pr.getName());
        Assertions.assertEquals(description, pr.getDescription());
        Assertions.assertEquals(quantity, pr.getQuantity());
    }

    /**
     * Тест для метода getAllProducts.
     */
    @Test
    void testGetAllProducts() {
        ProductDto product1 = new ProductDto();
        product1.setName("Стол");
        product1.setDescription("Описание стола");
        product1.setCategory("Мебель");
        product1.setPrice(BigDecimal.valueOf(5000));
        product1.setQuantity(5);
        productService.createProduct(product1);

        ProductDto product2 = new ProductDto();
        product2.setName("Стул");
        product2.setDescription("Описание стула");
        product2.setCategory("Мебель");
        product2.setPrice(BigDecimal.valueOf(10000));
        product2.setQuantity(2);
        productService.createProduct(product2);

        List<ProductDto> products = productService.getAllProducts();
        Assertions.assertEquals(products.size(), 2);
    }

    /**
     * Тест для метода getAllProducts, когда список товаров пустой.
     */
    @Test
    void testGetAllProductsEmpty() {
        List<ProductDto> products = productService.getAllProducts();
        Assertions.assertEquals(products.size(), 0);
    }

    /**
     * Тест для проверки обработки исключения ProductNotFoundException при удалении несуществующего продукта.
     */
    @Test
    void testDeleteNotExistingProduct(){
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.deleteProduct(UUID.randomUUID()));
    }

    /**
     * Юнит-тест для метода deleteAllProducts.
     */
    @Test
    void testDeleteProduct() {
        ProductDto product1 = new ProductDto();
        product1.setName("Стол");
        product1.setDescription("Описание стола");
        product1.setCategory("Мебель");
        product1.setPrice(BigDecimal.valueOf(5000));
        product1.setQuantity(5);
        productService.createProduct(product1);

        productService.deleteAllProducts();
        List<ProductDto> products = productService.getAllProducts();
        Assertions.assertEquals(products.size(), 0);
    }
}
