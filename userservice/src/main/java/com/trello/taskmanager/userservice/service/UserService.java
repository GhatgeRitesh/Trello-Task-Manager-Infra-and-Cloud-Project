package com.trello.taskmanager.userservice.service;

import com.trello.taskmanager.userservice.entity.UserEntity;
import com.trello.taskmanager.userservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(UserEntity user){
        UserEntity result=userRepository.save(user);
        if(result.getUserId() == null) {
            log.info("Registration Failed: Database failed to generate ID");
            return false;
        }
        return true;
    }

    public UserEntity getUserEntity(Long userId){
        UserEntity user= userRepository.getById(userId);
        if(user == null){
            log.info("Failed to pull User Details");
            return null;
        }
        return user;
    }

    public List<UserEntity> getAllUsers(){
        List<UserEntity> userEntities= userRepository.findAll();

        return userEntities;
    }
}
