package com.trello.taskmanager.projectservice.restcontroller;


import com.trello.taskmanager.projectservice.DTO.ProjectDTO;
import com.trello.taskmanager.projectservice.entity.ProjectEntity;
import com.trello.taskmanager.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project-service/new-project")
public class Project {

//    1. add new project and project members
//    2. add project members
//    3. add project work
//
    @Autowired
    private ProjectService projectService;

    @PostMapping("/createNewProject")
    public ResponseEntity<?> createNewProject(@Validated @RequestBody ProjectDTO projectDTO){

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
