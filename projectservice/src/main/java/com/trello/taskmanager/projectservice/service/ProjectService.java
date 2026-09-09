package com.trello.taskmanager.projectservice.service;

import com.trello.taskmanager.projectservice.DTO.ProjectDTO;
import com.trello.taskmanager.projectservice.entity.ProjectEntity;
import com.trello.taskmanager.projectservice.entity.TaskEntity;
import com.trello.taskmanager.projectservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    //create project
    public ProjectDTO createproject(ProjectDTO dto) {

        if (projectRepository.existsByOwnerIDAndName(dto.getOwnerID(), dto.getName())) {
            throw new IllegalArgumentException("You already have a project named '" + dto.getName() + "'");
        }
        ProjectEntity projectEntity = ProjectEntity.builder()
                .name(dto.getName())
                .ownerID(dto.getOwnerID())
                .memberIDs(dto.getMemberIDs())
                .build();

        if (dto.getTasks() != null) {
            for (com.trello.taskmanager.projectservice.dto.TaskDTO taskDto : dto.getTasks()) {
                TaskEntity taskEntity = new TaskEntity();
                taskEntity.setTitle(taskDto.getTitle());
                taskEntity.setProject(projectEntity);

                projectEntity.getTasks().add(taskEntity);
            }
        }
        ProjectEntity savedEntity= projectRepository.save(projectEntity);
        return new ProjectDTO(
                savedEntity.getProjectID(),
                savedEntity.getName(),
                savedEntity.getOwnerID(),
                savedEntity.getMemberIDs(),
                savedEntity.getTasks()
        );
    }



    // delete project

    // add members

    // remove members

    // add request accepted members


}