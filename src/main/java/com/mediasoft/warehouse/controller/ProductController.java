package com.mediasoft.warehouse.controller;

import com.mediasoft.warehouse.dto.ProductDto;
import com.mediasoft.warehouse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST API контроллер для сущности <b>Product</b> (товар).
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    /**
     * Метод для создания товара.
     *
     * @param productDto объект, содержащий данные для создания товара.
     * @return ResponseEntity, содержащий объект ProductDto, представляющий сохраненный товар.
     */
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /**
     * Метод для получения товара по UUid.
     *
     * @param productId UUID, представляющий идентификатор товара.
     * @return ResponseEntity, содержащий ProductDto, представляющий полученный товар.
     */
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") UUID productId){
        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    /**
     * Метод для получения всех товаров.
     *
     * @return ResponseEntity, содержащий список объектов ProductDto, представляющих товары.
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Метод для редактирования товара.
     *
     * @param productId     UUID, представляющий идентификатор товара, который нужно обновить.
     * @param updateProduct объект ProductDto, содержащий новые данные для обновления продукта.
     * @return ResponseEntity, содержащий ProductDto, представляющий обновленный продукт.
     */
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") UUID productId,
                                                    @RequestBody ProductDto updateProduct){
        ProductDto productDto = productService.updateProduct(productId, updateProduct);
        return ResponseEntity.ok(productDto);
    }

    /**
     * Метод для удаления товара по UUid.
     *
     * @param productId UUID, представляющий идентификатор товара, который нужно удалить.
     * @return ResponseEntity, содержащий сообщение о успешном удалении товара.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") UUID productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Товар удален со склада");
    }

    /**
     * Метод для удаления всех товаров.
     */
    @DeleteMapping
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }
}
