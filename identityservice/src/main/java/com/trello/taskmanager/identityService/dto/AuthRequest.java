package com.trello.taskmanager.identityService.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
