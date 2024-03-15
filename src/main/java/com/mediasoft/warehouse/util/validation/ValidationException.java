package com.mediasoft.warehouse.util.validation;

import java.util.Set;

/**
 * Класс, используемый для обработки ошибок валидации.
 */
public class ValidationException extends RuntimeException {
    /**
     * Конструктор класса.
     *
     * @param <T>    тип, который нужно проверить.
     * @param errors множество строк с описанием ошибок валидации.
     */
    public <T> ValidationException(Set<String> errors) {
        super(String.join("\n", errors));
    }
}