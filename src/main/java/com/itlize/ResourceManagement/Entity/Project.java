package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int projectId;

    private String projectName;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_name")
    private String owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID")
    private Set<ProjectResource> projectResourceSet;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public Set<ProjectResource> getProjectResourceSet() {
        return projectResourceSet;
    }
}
