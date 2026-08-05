package com.trello.taskmanager.identityService.globalExceptionHandling;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

       @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex){

           String errorMessage= "User not found with provided id";

           String rootMessage= ex.getCause() != null ? ex.getCause().getMessage() : "";

           if(rootMessage.contains("entity") || rootMessage.toLowerCase().contains("no row with given identifier exists for entity")){
              int size= ex.getCause().getMessage().toString().length();
               errorMessage= "No user found for given userID : "+ex.getCause().getMessage().toString().substring(size-5,size-1);
           }

           ErrorResponse error= new ErrorResponse(
                   HttpStatus.EXPECTATION_FAILED.value(),
                   errorMessage,
                   LocalDateTime.now()
           );
           return new ResponseEntity<>(error, HttpStatus.OK);
       }

       @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException(UsernameNotFoundException ex){
           String errorMessage= "";
           String rootMessage= ex.getCause() !=null ? ex.getCause().getMessage() : "";

           if(rootMessage.contains("User not found with name") ){
                errorMessage= rootMessage;
           }

           ErrorResponse error= new ErrorResponse(
                   HttpStatus.NOT_FOUND.value(),
                   errorMessage,
                   LocalDateTime.now()
           );
           return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
       }
}
