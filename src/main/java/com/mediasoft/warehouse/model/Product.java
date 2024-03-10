package com.mediasoft.warehouse.model;

import jakarta.persistence.*;
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
    private String name; // название товара

    @Column(name = "description", nullable = false)
    private String description; // описание

    @Column(name = "category", nullable = false)
    private String category; // категория

    @Column(name = "price", nullable = false)
    private BigDecimal price; // цена

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // количество

    @Column(name = "date_change", nullable = false)
    private Date dateChange; // дата и время последнего изменения количества

    @Column(name = "date_create", nullable = false)
    private Date dateCreate; // дата создания
}
