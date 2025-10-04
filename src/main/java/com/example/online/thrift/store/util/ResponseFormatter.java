package com.example.online.thrift.store.util;


import java.time.LocalDateTime;

public class ResponseFormatter {


    private Integer statusCode;
    private LocalDateTime responseDateTime;
    private String responseMessage;
    private Object responseBody;

    public ResponseFormatter(Integer statusCode, LocalDateTime responseDateTime, String responseMessage, Object responseBody) {
        this.statusCode = statusCode;
        this.responseDateTime = responseDateTime;
        this.responseMessage = responseMessage;
        this.responseBody = responseBody;
    }

    public ResponseFormatter() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(LocalDateTime responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }
}



