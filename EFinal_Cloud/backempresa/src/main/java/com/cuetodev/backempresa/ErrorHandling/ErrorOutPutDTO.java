package com.cuetodev.backempresa.ErrorHandling;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ErrorOutPutDTO extends RuntimeException {
    private Integer httpCode;
    private String msgError;
    private String type;
    private Date date;

    public ErrorOutPutDTO(Integer httpCode, String msgError, String type) {
        super();
        this.httpCode = httpCode;
        this.msgError = msgError;
        this.type = type; // Fatal, Warning, Info
        this.date = java.sql.Date.valueOf(LocalDate.now()); // Transform LocalDate to Date
    }
}
