package com.example.online.thrift.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(NotFoundException.class)

    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException e){

        ErrorResponse response = new ErrorResponse(404, LocalDateTime.now(),e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(AlreadyExistException.class)

    public ResponseEntity<?> alreadyExistExceptionHandeler(AlreadyExistException e){

        ErrorResponse response = new ErrorResponse(409,LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidException.class)

    public ResponseEntity<?> InvalidExceptionHandeler(InvalidException e){

        ErrorResponse response = new ErrorResponse(409,LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allExceptionHandler(Exception e){

        ErrorResponse response = new ErrorResponse(400,LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
