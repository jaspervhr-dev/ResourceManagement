package com.itlize.ResourceManagement.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class ResourceDetail {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime time_created;

    private String column_value;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resource_detail",cascade = CascadeType.ALL)
    private Set<ProjectColumn> columnSet;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "resource_id")
    private Integer resource_id;

    public Integer getId() {
        return id;
    }

    public Set<ProjectColumn> getColumnSet() {
        return columnSet;
    }

    public Integer getResource_id() {
        return resource_id;
    }

    public String getColumn_value() {
        return column_value;
    }

    public LocalDateTime getTime_created() {
        return time_created;
    }

    public void setColumnSet(Set<ProjectColumn> columnSet) {
        this.columnSet = columnSet;
    }

    public void setColumn_value(String column_value) {
        this.column_value = column_value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.time_created = time_created;
    }
}
