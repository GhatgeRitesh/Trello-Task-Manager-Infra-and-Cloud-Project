package com.trello.taskmanager.identityService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserDetails")
@Getter @Setter
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

    @Override
    public String toString(){
        return "{\n User Account Details: Name:"+ name +"\n EmailId: "+email+"\n contact: "+contact+"\n }";
    }

}
