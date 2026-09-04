package com.trello.taskmanager.projectservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ProjectDTO {

    private String name;
    private Long ownerId;

}
