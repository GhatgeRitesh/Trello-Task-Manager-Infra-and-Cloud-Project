package com.trello.taskmanager.userservice.service;

import com.trello.taskmanager.userservice.dto.RegistrationRequestDTO;
import com.trello.taskmanager.userservice.dto.UserResponseDTO;
import com.trello.taskmanager.userservice.entity.UserEntity;
import com.trello.taskmanager.userservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(RegistrationRequestDTO user){

        UserEntity userEntity= new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setContact(user.getContact());
        userEntity.setPassword(user.getPassword());
        UserEntity result=userRepository.save(userEntity);
        if(result.getUserId() == null) {
            log.info("Registration Failed: Database failed to generate ID");
            return false;
        }
        return true;
    }

    public UserResponseDTO getUserEntity(Long userId){
        UserEntity user= userRepository.getById(userId);

        if(user == null){
            log.info("Failed to pull User Details");
            return null;
        }

        UserResponseDTO responseDTO= new UserResponseDTO();

        responseDTO.setUserId(user.getUserId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setContact(user.getContact());

        return responseDTO;
    }

    public List<UserResponseDTO> getAllUsers(){
        List<UserEntity> userEntities= userRepository.findAll();

        return userEntities.stream()
                .map(entity -> new UserResponseDTO(
                        entity.getUserId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getContact()
                 ))
                .toList();
    }
}
