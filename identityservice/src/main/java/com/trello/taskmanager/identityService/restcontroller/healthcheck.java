package com.trello.taskmanager.identityService.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/users")
public class healthcheck {

     @GetMapping("/health")
    public String sendRespond(){
          return "OK";
     }

     @GetMapping("/getList")
    public ResponseEntity<?> getList(){
         System.out.println("Printing List");
         ArrayList<String> list= new ArrayList<>();
         list.add("a");
         list.add("b");
         return new ResponseEntity<>(list, HttpStatus.OK);
     }
}
