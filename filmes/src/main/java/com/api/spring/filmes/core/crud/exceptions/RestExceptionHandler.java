package com.api.spring.filmes.core.crud.exceptions;

import com.api.spring.filmes.service.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<StandardError> handlerFieldsError(MethodArgumentNotValidException ex, HttpServletRequest request) {

        FieldError firstFieldWithError = ex.getFieldErrors().get(ex.getFieldErrors().size() - 1);
        var nameFieldError = firstFieldWithError.getField();

        String error = "VALIDATION FAILED!";
        String message = nameFieldError.toUpperCase() + " " + firstFieldWithError.getDefaultMessage();
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.toUpperCase(), message, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<StandardError> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        String error = "RESOURCE NOT FOUND!";
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.toUpperCase(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }


    @ExceptionHandler(ConnectException.class)
    private ResponseEntity<StandardError> handleEntityNotFound(ConnectException ex, HttpServletRequest request) {
        String error = "ERRO INTERNO";
        StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), error.toUpperCase(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}