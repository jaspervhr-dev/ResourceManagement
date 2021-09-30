package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_resources")
public class ProjectResource {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private int recordId;

    @Timestamp
    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Integer projectId;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Integer resourceId;
}
