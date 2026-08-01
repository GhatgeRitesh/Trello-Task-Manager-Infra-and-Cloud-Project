package com.trello.taskmanager.userservice.dto;

import lombok.Data;


@Data
public class RegistrationRequestDTO {
    private String name;
    private String email;
    private Long contact;
    private String password;
}
