package com.accenture.controller.advice;

import com.accenture.exception.ClientException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientControllerAdvice {

    private final MessageSource messageSource;

    public ClientControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler({ClientException.class})
    public ResponseEntity<ErrorDto> businessException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorDto(
                java.time.LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorsDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorsDto errorsDto = new ErrorsDto(
                java.time.LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getAllErrors().stream()
                        .map(error -> new ErrorValidDto(
                                ((FieldError) error).getField(),
                                messageSource.getMessage(error.getDefaultMessage(), null, LocaleContextHolder.getLocale())
                        ))
                        .toList()
        );

        return ResponseEntity.badRequest().body(errorsDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> ex(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorDto(
                java.time.LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        ));
    }
}
