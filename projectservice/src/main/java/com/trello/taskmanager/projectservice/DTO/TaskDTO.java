package com.trello.taskmanager.projectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Useful for easily building DTOs in your service layer
public class TaskDTO {

    private Long workID;
    private String title;
    private String description;

    // Can belong to either the project owner ID or a member ID
    private Long userID;

    // Flattened relation: Exposes just the ID instead of the entire project object graph
    private Long projectID;
}
