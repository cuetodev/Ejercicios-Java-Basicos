package com.cuetodev.ej3_1.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
