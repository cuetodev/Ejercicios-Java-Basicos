package com.cuetodev.backweb.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> handleErrorOutPutDTO(ErrorOutPutDTO errorOutPutDTO) {
        return new ResponseEntity<>(errorOutPutDTO, HttpStatus.NOT_IMPLEMENTED);
    }

}
