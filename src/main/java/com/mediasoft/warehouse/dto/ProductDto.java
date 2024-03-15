package com.mediasoft.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * DTO для сущности <b>Product</b> (товар).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    /**
     * Уникальный идентификатор товара (артикул).
     */
    private UUID id;

    /**
     * Название товара.
     */
    private String name;

    /**
     * Описание товара.
     */
    private String description;

    /**
     * Категория товара.
     */
    private String category;

    /**
     * Цена товара.
     */
    private BigDecimal price;

    /**
     * Количество товара.
     */
    private Integer quantity;

    /**
     * Дата и время последнего изменения количества.
     */
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateChange;

    /**
     * Дата создания.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateCreate;
}
