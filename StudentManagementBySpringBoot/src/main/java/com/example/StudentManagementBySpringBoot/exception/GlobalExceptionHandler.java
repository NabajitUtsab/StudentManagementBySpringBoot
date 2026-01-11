package com.example.StudentManagementBySpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonResponse> handleNoSuchElementException(NoSuchElementException e) {
        CommonResponse commonErrorResponse = new CommonResponse(
                Instant.now().toString(),
                e.getClass().toString(),
                e.getMessage()
        );

        return new ResponseEntity<>(commonErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CommonResponse> handleRuntimeException(RuntimeException e) {
        CommonResponse commonErrorResponse = new CommonResponse(
                Instant.now().toString(),
                e.getClass().toString(),
                "Runtime Exception happening"
        );

        return new ResponseEntity<>(commonErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
