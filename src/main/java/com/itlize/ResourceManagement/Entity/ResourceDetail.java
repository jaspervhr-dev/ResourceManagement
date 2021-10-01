package com.itlize.ResourceManagement.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "resources_details")
public class ResourceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="record_id")
    private Integer recordId;

    private LocalDateTime timeCreated;
    @Column(name = "column_value")
    private String columnValue;

    @ManyToOne(targetEntity = ProjectColumn.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "column_id")
    private ProjectColumn column;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Resource resource;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public ProjectColumn getColumn() {
        return column;
    }

    public void setColumn(ProjectColumn column) {
        this.column = column;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString(){
        return "Id: "+this.recordId+"Column: "+this.column+"Create Time: "+this.timeCreated+"Resource: " +this.resource;
    }
}
