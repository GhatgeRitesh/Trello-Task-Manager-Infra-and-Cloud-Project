package com.trello.taskmanager.userservice.repository;

import com.trello.taskmanager.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long> {


}
