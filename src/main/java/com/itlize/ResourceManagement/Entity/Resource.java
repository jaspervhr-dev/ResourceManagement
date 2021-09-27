package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Resource {

    @Id
    @GeneratedValue
    private int resourceId;

    private String resourceName;

    @Timestamp
    private LocalDateTime timeCreated;

    @Timestamp
    private LocalDateTime lastUpdated;

    @OneToMany
    @JoinColumn(name = "resourceID")
    private Set<ProjectResource> projectResourceSet;

    @ManyToOne
    @JoinColumn(name = "resourceID")
    private Set<ResourceDetail> resourceDetailSet;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public Set<ProjectResource> getProjectResourceSet() {
        return projectResourceSet;
    }

    public Set<ResourceDetail> getResourceDetailSet() {
        return resourceDetailSet;
    }
}
