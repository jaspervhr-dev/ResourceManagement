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
    @Column(name = "resource_id")
    private int resourceId;

    @Column(name = "recource_name")
    private String resourceName;

    @Timestamp
    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Timestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resourceId", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ProjectResource> projectResourceSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resourceId", cascade = CascadeType.ALL)
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
