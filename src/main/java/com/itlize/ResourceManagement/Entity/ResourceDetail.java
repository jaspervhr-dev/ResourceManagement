package com.itlize.ResourceManagement.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "resources_details")
public class ResourceDetail {
    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Column(name = "column_value")
    private String columnValue;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "column_id")
    private ProjectColumn columnId;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Integer resourceId;

    public Integer getId() {return recordId;}

    public ProjectColumn getColumnSet() {return columnId;}

    public Integer getResource_id() {return resourceId;}

    public String getColumn_value() {return columnValue;}

    public LocalDateTime getTime_created() {return timeCreated;}

    public void setColumnSet(ProjectColumn column_id) {this.columnId = column_id;}

    public void setColumn_value(String column_value) {this.columnValue = column_value;}

    public void setId(Integer id) {
        this.recordId = id;
    }

    public void setResource_id(Integer resource_id) {
        this.resourceId = resource_id;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.timeCreated = time_created;
    }
}
