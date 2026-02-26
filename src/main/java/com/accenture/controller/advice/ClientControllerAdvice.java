package com.accenture.controller.advice;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientControllerAdvice {

    private final MessageSource messageSource;

    public ClientControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
