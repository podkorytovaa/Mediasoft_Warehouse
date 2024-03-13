package com.mediasoft.warehouse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // артикул

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Поле name не может быть null или пустым")
    private String name; // название товара

    @Column(name = "description", nullable = false)
    @NotBlank(message = "Поле description не может быть null или пустым")
    private String description; // описание

    @Column(name = "category", nullable = false)
    @NotBlank(message = "Поле category не может быть null или пустым")
    private String category; // категория

    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Поле price не может быть меньше 0")
    @NotNull(message = "Поле price не может быть null")
    private BigDecimal price; // цена

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "Поле quantity не может быть меньше 0")
    @NotNull(message = "Поле price не может быть null")
    private Integer quantity; // количество

    @Column(name = "date_change", nullable = false)
    private Date dateChange; // дата и время последнего изменения количества

    @Column(name = "date_create", nullable = false)
    private Date dateCreate; // дата создания
}
