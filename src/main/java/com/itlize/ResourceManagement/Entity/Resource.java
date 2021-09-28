package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue
    private int resourceId;

    private String resourceName;

    @Timestamp
    private LocalDateTime timeCreated;

    @Timestamp
    private LocalDateTime lastUpdated;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource_id", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ProjectResource> projectResourceSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource_id", cascade = CascadeType.ALL)
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
