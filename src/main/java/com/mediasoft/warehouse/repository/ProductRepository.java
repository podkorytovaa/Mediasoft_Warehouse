package com.mediasoft.warehouse.repository;

import com.mediasoft.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Интерфейс репозитория для работы с товарами.
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
