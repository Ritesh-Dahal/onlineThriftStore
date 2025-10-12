package com.example.online.thrift.store.exception;

public class InvalidException extends RuntimeException {
    public InvalidException(String message) {
        super(message);
    }
}
