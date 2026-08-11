package com.trello.taskmanager.identityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserDetails")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name= "email", unique = true, nullable = false)
    private String email;

    @Column(name = "contact", nullable = false)
    private Long contact;

    @Column(name= "Password", nullable = false)
    private String password;

    // --- NEW: Added roles collection ---
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<String> roles = new ArrayList<>();

    @Override
    public String toString(){
        return "{\n User Account Details: Name:"+ name +"\n EmailId: "+email+"\n contact: "+contact+"\n Roles: "+roles+"\n }";
    }

}
