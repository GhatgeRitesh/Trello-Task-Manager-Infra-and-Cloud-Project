package com.trello.taskmanager.userservice.restcontroller;

import com.trello.taskmanager.userservice.entity.UserEntity;
import com.trello.taskmanager.userservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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
    @PostMapping("/new-registration")
    public ResponseEntity<?> registerNewUser(@Validated  @RequestBody UserEntity user){
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
          UserEntity user=userService.getUserEntity(id);
          if(user == null){
              return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
