package com.trello.taskmanager.identityService.repository;

import com.trello.taskmanager.identityService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long> {


}
