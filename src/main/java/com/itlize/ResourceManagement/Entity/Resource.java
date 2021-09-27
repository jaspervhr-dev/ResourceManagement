package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private Set<ProjectResource> projectResourceSet;

    @ManyToOne
    private Set<ResourceDetail> resourceDetailSet;
}
