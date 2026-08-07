package com.trello.taskmanager.identityService.repository;

import com.trello.taskmanager.identityService.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(" Select u from UserEntity u where u.name = :username")
    Optional<UserEntity> findByName(@Param("username") String Username);

    @Query("delete  from UserEntity u where u.userId = :userId")
    void deleteById(@Param("userId") Long id);
}
