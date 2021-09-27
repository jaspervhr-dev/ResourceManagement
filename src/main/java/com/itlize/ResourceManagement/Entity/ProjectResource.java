package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

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

}
