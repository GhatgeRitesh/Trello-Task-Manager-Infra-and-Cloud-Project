package com.trello.taskmanager.identityService.restcontroller;

import com.trello.taskmanager.identityService.dto.RegistrationRequestDTO;
import com.trello.taskmanager.identityService.dto.UserResponseDTO;
import com.trello.taskmanager.identityService.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;


    // 1. Register User Deatails
    @PostMapping("/auth/new-registration")
    public ResponseEntity<?> registerNewUser(@Validated  @RequestBody RegistrationRequestDTO user){
        log.info("New user registration process started");
        log.info("User Details: ", user.toString());
        Boolean flag= userService.saveUser(user);
        if(! flag){
            return new ResponseEntity<>(user,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    // 2. Retrive User Details
    @GetMapping("/getUserDetails/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable("user_id") Long id){

          UserResponseDTO responseDTO= new UserResponseDTO();

           responseDTO =userService.getUserEntity(id);
          if(responseDTO== null){
              return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
