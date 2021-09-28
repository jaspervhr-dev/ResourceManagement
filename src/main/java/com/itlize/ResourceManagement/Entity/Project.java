package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int project_id;

    private String project_name;

    @Timestamp
    private LocalDateTime time_created;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_name")
    private String owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    private Set<ProjectResource> projectResourceSet;

    public int getProjectId() {
        return project_id;
    }

    public void setProjectId(int projectId) {
        this.project_id = projectId;
    }

    public String getProjectName() {
        return project_name;
    }

    public void setProjectName(String projectName) {
        this.project_name = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getTimeCreated() {
        return time_created;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {this.time_created = timeCreated;}

    public Set<ProjectResource> getProjectResourceSet() {
        return projectResourceSet;
    }

    public void setProjectResourceSet(Set<ProjectResource> projectResourceSet) {this.projectResourceSet = projectResourceSet;}
}
