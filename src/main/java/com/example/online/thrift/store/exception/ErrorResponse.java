package com.example.online.thrift.store.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private Integer statusCode;
    private LocalDateTime date;
    private String messgae;

    public ErrorResponse(Integer statusCode, LocalDateTime date, String messgae) {
        this.statusCode = statusCode;
        this.date = date;
        this.messgae = messgae;
    }



    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
