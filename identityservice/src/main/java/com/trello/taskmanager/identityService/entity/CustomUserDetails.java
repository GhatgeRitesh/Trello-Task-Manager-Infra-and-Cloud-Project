package com.trello.taskmanager.identityService.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserDetails implements UserDetails {
    private final String username;
    private final String password;
    private final Collection<? extends  GrantedAuthority> authorities;

    public CustomUserDetails(UserEntity user){
        this.username= user.getName();
        this.password= user.getPassword();
        this.authorities=user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return your user roles here. Using an empty list for basic setup.
        return this.authorities;
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
