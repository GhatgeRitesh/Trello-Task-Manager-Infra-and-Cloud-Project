package com.trello.taskmanager.projectservice.service;

import com.trello.taskmanager.projectservice.entity.ProjectEntity;
import com.trello.taskmanager.projectservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void createProject(ProjectEntity pro)
}