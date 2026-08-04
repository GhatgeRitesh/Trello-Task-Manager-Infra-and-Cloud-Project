package com.trello.taskmanager.identityService.globalExceptionHandling;

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
