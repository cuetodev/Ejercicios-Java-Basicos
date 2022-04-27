package com.cuetodev.ej3_1.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException  extends RuntimeException {
    public UnprocesableException(String message) {
        super(message);
    }
}