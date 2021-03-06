package com.itlize.ResourceManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    private Set<ProjectResource> projectResourceSet;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    private Set<ProjectColumn> projectColumnSet;

    public Set<ProjectColumn> getProjectColumnSet() {
        return projectColumnSet;
    }

    public void setProjectColumnSet(Set<ProjectColumn> projectColumnSet) {
        this.projectColumnSet = projectColumnSet;
    }

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

    public User getOwner() {return owner;}

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {this.timeCreated = timeCreated;}

    public Set<ProjectResource> getProjectResourceSet() {
        return projectResourceSet;
    }

    public void setProjectResourceSet(Set<ProjectResource> projectResourceSet) {this.projectResourceSet = projectResourceSet;}

    @Override
    public String toString(){
        return "ProjectId: " + getProjectId() + "\n" +
                "Project Name: " + getProjectName() + "\n" +
                "Owner: " + getOwner();
    }
}
