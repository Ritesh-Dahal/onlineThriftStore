package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.util.ResponseFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class BaseController extends ResponseFormatter {

    public static ResponseEntity<?> successResponse(String message, Object responseBody){

        ResponseFormatter responseBodyObject = new ResponseFormatter();
        responseBodyObject.setStatusCode(200);
        responseBodyObject.setResponseDateTime(LocalDateTime.now());
        responseBodyObject.setResponseMessage(message);
        responseBodyObject.setResponseBody(responseBody);

        return  new ResponseEntity<>(responseBodyObject, HttpStatus.OK);



    }

    public static ResponseEntity<?> failResponse(String message,Object responseBody){
        ResponseFormatter responseBodyObject = new ResponseFormatter();
        responseBodyObject.setStatusCode(404);
        responseBodyObject.setResponseDateTime(LocalDateTime.now());
        responseBodyObject.setResponseMessage(message);
        responseBodyObject.setResponseBody(responseBody);

        return  new ResponseEntity<>(responseBodyObject, HttpStatus.NOT_FOUND);



    }
}
