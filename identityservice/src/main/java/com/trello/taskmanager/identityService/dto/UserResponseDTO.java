package com.trello.taskmanager.identityService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {



    private Long userId;
    private String name;
    private String email;
    private Long contact;



}

