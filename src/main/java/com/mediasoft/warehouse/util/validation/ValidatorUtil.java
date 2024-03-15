package com.mediasoft.warehouse.util.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Класс, используемый для валидации объектов.
 */
@Component
public class ValidatorUtil {
    private final Validator validator;

    /**
     * Конструктор класса.
     */
    public ValidatorUtil() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * Метод для валидации объекта.
     *
     * @param <T>    тип объекта, который нужно проверить.
     * @param object объект, который нужно проверить.
     * @throws ValidationException если объект не проходит валидацию, выбрасывается исключение ValidationException.
     */
    public <T> void validate(T object) {
        final Set<ConstraintViolation<T>> errors = validator.validate(object);
        if (!errors.isEmpty()) {
            throw new ValidationException(errors.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet()));
        }
    }
}