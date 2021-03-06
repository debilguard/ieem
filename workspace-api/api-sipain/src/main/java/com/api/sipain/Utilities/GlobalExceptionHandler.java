package com.api.sipain.Utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.sipain.entities.resError;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<resError> GlobalExceptionResponse(Exception ex) {
        return new ResponseEntity<>(new resError("401",ex.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
    }
}