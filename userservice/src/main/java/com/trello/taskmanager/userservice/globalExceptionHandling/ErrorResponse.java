package com.trello.taskmanager.userservice.globalExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    int status;
    String message;
    LocalDateTime timestamp;
}
