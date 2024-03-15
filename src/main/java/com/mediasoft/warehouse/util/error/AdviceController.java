package com.mediasoft.warehouse.util.error;

import com.mediasoft.warehouse.exception.ProductNotFoundException;
import com.mediasoft.warehouse.util.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * Класс, отвечающий за обработку исключений в контроллерах.
 */
@ControllerAdvice
public class AdviceController {
    /**
     * Обработчик исключений ProductNotFoundException и ValidationException.
     *
     * @param e исключение, которое нужно обработать.
     * @return ResponseEntity с сообщением об ошибке и статусом HTTP.
     */
    @ExceptionHandler({
            ProductNotFoundException.class,
            ValidationException.class
    })
    public ResponseEntity<Object> handleException(Throwable e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Обработчик исключения MethodArgumentNotValidException.
     *
     * @param e исключение MethodArgumentNotValidException, которое нужно обработать.
     * @return ResponseEntity с сообщением об ошибке и статусом HTTP.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBindException(MethodArgumentNotValidException e) {
        final ValidationException validationException = new ValidationException(
                e.getBindingResult().getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toSet()));
        return handleException(validationException);
    }

    /**
     * Обработчик неизвестного исключения.
     *
     * @param e исключение, которое нужно обработать.
     * @return ResponseEntity с сообщением об ошибке и статусом HTTP.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownException(Throwable e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}