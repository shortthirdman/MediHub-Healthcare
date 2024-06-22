package com.shortthirdman.medihub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractBaseController {

    public <T> ResponseEntity<T> buildSuccessResponse(T response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
