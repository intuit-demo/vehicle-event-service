package com.intuit.vehicleeventservice.common.exceptions;


import com.intuit.vehicleeventservice.common.exceptions.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleCustomNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(Error.builder()
                .message(ex.getMessage())
                .statusCode(String.valueOf(HttpStatus.NOT_FOUND.value())).build()
                , HttpStatus.NOT_FOUND);
    }
}
