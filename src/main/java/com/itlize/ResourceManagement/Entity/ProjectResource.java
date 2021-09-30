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
    private Project project;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Resource resource;


    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
