package com.sonu.userMicroService.exception;

import com.sonu.userMicroService.payloads.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> handleUserNotFoundException(UserNotFoundException ex) {

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(ex.getMessage(),true, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(apiExceptionResponse,HttpStatus.NOT_FOUND);
    }
}
