package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Entity
public class ProjectResource {

    @Id
    @GeneratedValue
    private int record_id;

    @Timestamp
    private LocalDateTime time_created;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Integer project_id;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Integer resource_id;

    public int getRecord_id() {return record_id;}

    public void setRecord_id(int record_id) {this.record_id = record_id;}

    public LocalDateTime getTime_created() {return time_created;}

    public void setTime_created(LocalDateTime time_created) {this.time_created = time_created;}

    public Integer getProject_id() {return project_id;}

    public void setProject_id(Integer project_id) {this.project_id = project_id;}

    public Integer getResource_id() {return resource_id;}

    public void setResource_id(Integer resource_id) {this.resource_id = resource_id;}
}
