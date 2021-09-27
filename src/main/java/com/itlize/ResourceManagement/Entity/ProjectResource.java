package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProjectResource {

    @Id
    @GeneratedValue
    private int recordID;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private int projectID;

    @ManyToOne
    @JoinColumn(name = "resourceId")
    private int resourceId;
}
