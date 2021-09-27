package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int projectId;

    private String projectName;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne
    @JoinColumn(name = "username")
    private String owner;
}
