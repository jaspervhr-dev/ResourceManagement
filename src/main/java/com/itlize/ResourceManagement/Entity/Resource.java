package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Resource {

    @Id
    @GeneratedValue
    private int resource_id;

    private String resource_name;

    @Timestamp
    private LocalDateTime time_created;

    @Timestamp
    private LocalDateTime last_updated;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ProjectResource> projectResourceSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource", cascade = CascadeType.ALL)
    private Set<ResourceDetail> resourceDetailSet;

    public int getResourceId() {
        return resource_id;
    }

    public void setResourceId(int resourceId) {
        this.resource_id = resourceId;
    }

    public String getResourceName() {
        return resource_name;
    }

    public void setResourceName(String resourceName) {
        this.resource_name = resourceName;
    }

    public LocalDateTime getTimeCreated() {
        return time_created;
    }

    public LocalDateTime getLastUpdated() {
        return last_updated;
    }

    public Set<ProjectResource> getProjectResourceSet() {
        return projectResourceSet;
    }

    public Set<ResourceDetail> getResourceDetailSet() {
        return resourceDetailSet;
    }
}
