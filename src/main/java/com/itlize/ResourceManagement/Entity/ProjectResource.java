package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProjectResource {

    @Id
    @GeneratedValue
    private int recordID;

    @Timestamp
    private LocalDateTime timeCreated;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private int projectID;

    @ManyToOne
    @JoinColumn(name = "resourceId")
    private int resourceId;

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
