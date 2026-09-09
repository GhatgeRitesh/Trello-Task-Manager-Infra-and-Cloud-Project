package com.trello.taskmanager.projectservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name  = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ownerId", nullable = false)
    private Long ownerID;


    @ElementCollection
    @CollectionTable(
            name = "project_members" ,
            joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name =  "member_id")
    private Set<Long> memberIDs = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskEntity> tasks=  new ArrayList<>();

}
