package com.trello.taskmanager.identityService.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class CustomUserDetails implements UserDetails {
    private final String username;
    private final String password;

    public CustomUserDetails(UserEntity user){
        this.username= user.getName();
        this.password= user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return your user roles here. Using an empty list for basic setup.
        return List.of();
    }

    @Override
    public String getPassword(){return password;}

    @Override
    public String getUsername(){return username;}

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
