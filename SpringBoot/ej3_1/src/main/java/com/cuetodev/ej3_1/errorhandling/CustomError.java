package com.cuetodev.ej3_1.errorhandling;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    private Date timestamp;
    private Integer HttpCode;
    private String mensaje;

    public CustomError(Date timestamp, Integer httpCode, String message) {
        super();
        this.timestamp = timestamp;
        this.HttpCode = httpCode;
        this.mensaje = message;
    }
}
