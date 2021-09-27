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
}
