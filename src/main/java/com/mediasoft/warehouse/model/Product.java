package com.mediasoft.warehouse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Класс-сущность товар.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    /**
     * Уникальный идентификатор товара (артикул).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Название товара.
     */
    @Column(name = "name", nullable = false)
    @NotBlank(message = "Поле name не может быть null или пустым")
    private String name;

    /**
     * Описание товара.
     */
    @Column(name = "description", nullable = false)
    @NotBlank(message = "Поле description не может быть null или пустым")
    private String description;

    /**
     * Категория товара.
     */
    @Column(name = "category", nullable = false)
    @NotBlank(message = "Поле category не может быть null или пустым")
    private String category;

    /**
     * Цена товара.
     */
    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Поле price не может быть меньше 0")
    @NotNull(message = "Поле price не может быть null")
    private BigDecimal price;

    /**
     * Количество товара.
     */
    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "Поле quantity не может быть меньше 0")
    @NotNull(message = "Поле price не может быть null")
    private Integer quantity;

    /**
     * Дата и время последнего изменения количества.
     */
    @Column(name = "date_change", nullable = false)
    private Date dateChange;

    /**
     * Дата создания.
     */
    @Column(name = "date_create", nullable = false)
    private Date dateCreate;
}
