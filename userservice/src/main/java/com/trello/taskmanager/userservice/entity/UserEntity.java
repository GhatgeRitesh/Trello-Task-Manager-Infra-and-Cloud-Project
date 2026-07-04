package com.trello.taskmanager.userservice.entity;

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

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name = "contact", nullable = false)
    private Long contact;

    @Override
    public String toString(){
        return "{\n User Account Details: Name:"+ name +"\n EmailId: "+email+"\n contact: "+contact+"\n }";
    }

}
