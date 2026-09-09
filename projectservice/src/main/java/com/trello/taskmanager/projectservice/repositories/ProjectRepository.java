package com.trello.taskmanager.projectservice.repositories;

import com.trello.taskmanager.projectservice.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {
    boolean existsByOwnerIDAndName(Long ownerID, String name);
}
