package com.devChallengue.WSClientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientCreationException.class)
    public ResponseEntity<String> handleClientCreationException(ClientCreationException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> handleClientNotFoundException(ClientNotFoundException cfex){
        return new ResponseEntity<>(cfex.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenerixException(Exception ex){
        return new ResponseEntity<>("Error interno de lado del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
