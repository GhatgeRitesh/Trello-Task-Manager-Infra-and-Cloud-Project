package com.trello.taskmanager.identityService.restcontroller;

import com.trello.taskmanager.identityService.dto.AuthRequest;
import com.trello.taskmanager.identityService.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody AuthRequest authRequest){
         authenticationManager
                 .authenticate(
                         new UsernamePasswordAuthenticationToken(
                                 authRequest.getUsername(),
                                 authRequest.getPassword())
                 );
        String token = jwtService.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(Map.of("token", token));

    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
