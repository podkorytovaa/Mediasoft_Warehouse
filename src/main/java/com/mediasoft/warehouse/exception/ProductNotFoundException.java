package com.mediasoft.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, выбрасываемое при отсутствии продукта.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

    /**
     * Конструктор класса.
     *
     * @param message сообщение об ошибке.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }

}
