package com.trello.taskmanager.userservice.globalExceptionHandling;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

       @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegeratyVoilation(DataIntegrityViolationException ex){
           String errorMessage= "A database conflict occurred";

           String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : "";

           if( rootMessage.contains("email") || rootMessage.toLowerCase().contains("uk_")){
               errorMessage= "Registration failed: An account with this email address already exists. ";
           }
           ErrorResponse errorResponse= new ErrorResponse(
                   HttpStatus.CONFLICT.value(),
                   errorMessage,
                   LocalDateTime.now()
           );

           return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
       }
}
