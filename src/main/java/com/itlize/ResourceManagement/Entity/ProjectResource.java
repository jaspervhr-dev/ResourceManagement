package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Entity
public class ProjectResource {

    @Id
    @GeneratedValue
    private int recordID;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "projectID")
    private Integer projectID;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resourceId")
    private Integer resourceId;
}
