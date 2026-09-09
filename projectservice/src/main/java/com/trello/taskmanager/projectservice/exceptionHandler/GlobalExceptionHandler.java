package com.trello.taskmanager.projectservice.exceptionHandler;

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
        String errorMessage= "";
        String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : "";

        ErrorResponse errorResponse= new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex){
        String errorMessage= "";
        String rootMessage= ex.getMessage() != null ? ex.getMessage(): "null pointer exception needs supervision";

        ErrorResponse errorResponse= new ErrorResponse(
                HttpStatus.EXPECTATION_FAILED.value(),
                rootMessage,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex){
        String errorMessage= "";
        String rootMessage= ex.getMessage() != null ? ex.getMessage(): errorMessage;

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NO_CONTENT.value(),
                rootMessage,
                LocalDateTime.now()
        );
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
