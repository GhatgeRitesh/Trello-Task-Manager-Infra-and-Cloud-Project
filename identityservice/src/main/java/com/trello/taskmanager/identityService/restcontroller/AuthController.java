package com.trello.taskmanager.identityService.restcontroller;

import com.trello.taskmanager.identityService.dto.AuthRequest;

import com.trello.taskmanager.identityService.entity.CustomUserDetails;
import com.trello.taskmanager.identityService.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;



    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody AuthRequest authRequest){
       Authentication auth = authenticationManager
                 .authenticate(
                         new UsernamePasswordAuthenticationToken(
                                 authRequest.getUsername(),
                                 authRequest.getPassword())
                 );

       if(auth.isAuthenticated()) {

           CustomUserDetails userDetails= (CustomUserDetails) auth.getPrincipal();

           Long userId= userDetails.getUserId();
           List<String> roles = auth.getAuthorities().stream()
                   .map(GrantedAuthority::getAuthority)
                   .collect(Collectors.toList());


           String token = jwtService.generateToken(authRequest.getUsername(), roles,userId);
           return ResponseEntity.ok(Map.of("token", token));
       }
       return new ResponseEntity<>("Invalid credentials",HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
