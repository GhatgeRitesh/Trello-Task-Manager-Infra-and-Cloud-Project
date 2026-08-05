package com.trello.taskmanager.identityService.service;

import com.trello.taskmanager.identityService.entity.CustomUserDetails;
import com.trello.taskmanager.identityService.entity.UserEntity;
import com.trello.taskmanager.identityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Optional<UserEntity> user= Optional.of(userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)));

        return new CustomUserDetails(user.orElse(null));
    }
}
