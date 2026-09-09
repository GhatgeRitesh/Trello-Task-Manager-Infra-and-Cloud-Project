package com.trello.taskmanager.projectservice.DTO;



import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long projectID;
    private String name;
    private Long ownerID;
    private Set<Long> memberIDs;

    // Flattened relationship: Uses a TaskDTO list instead of TaskEntity
    private List<com.trello.taskmanager.projectservice.dto.TaskDTO> Tasks;


}


