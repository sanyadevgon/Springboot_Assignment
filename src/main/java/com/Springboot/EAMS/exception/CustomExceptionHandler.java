package com.Springboot.EAMS.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = GlobalEamsException.class)

    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(GlobalEamsException e) {

        CustomErrorResponse error = new CustomErrorResponse("NOT_FOUND_ERROR", e.getMessage());

        error.setTimestamp(LocalDateTime.now());

        error.setStatus((HttpStatus.NOT_FOUND.value()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = NullBodyException.class)

    public ResponseEntity<CustomErrorResponse> handleGenericNullBodyException(NullBodyException e) {

        CustomErrorResponse error = new CustomErrorResponse("DETAILS CANNOT BE EMPTY", e.getMessage());

        error.setTimestamp(LocalDateTime.now());

        error.setStatus((HttpStatus.BAD_REQUEST.value()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)

    public ResponseEntity<CustomErrorResponse> handleGenericDublicateDetailsException(DublicateDetailsException e) {

        CustomErrorResponse error = new CustomErrorResponse("DETAILS ALREADY EXISTS ", e.getMessage());

        error.setTimestamp(LocalDateTime.now());

        error.setStatus((HttpStatus.BAD_REQUEST.value()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }


}
