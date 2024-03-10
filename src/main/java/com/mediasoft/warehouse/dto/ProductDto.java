package com.mediasoft.warehouse.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id; // артикул
    private String name; // название товара
    private String description; // описание
    private String category; // категория
    private BigDecimal price; // цена
    private Integer quantity; // количество
    private Date dateChange; // дата и время последнего изменения количества
    private Date dateCreate; // дата создания
}
