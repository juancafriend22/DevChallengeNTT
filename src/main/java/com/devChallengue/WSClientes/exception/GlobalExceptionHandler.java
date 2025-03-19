package com.devChallengue.WSClientes.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
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
        // Generar un identificador único para rastrear el error en logs
        String errorId = UUID.randomUUID().toString();
        // Registrar el error en logs con el identificador
        log.error("Error inesperado - ID: {} - Mensaje: {}", errorId, ex.getMessage(), ex);

        // Devolver un mensaje con el identificador para que el cliente pueda reportarlo
        String errorMessage = "Ha ocurrido un error inesperado. Código de error: " + errorId;
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
