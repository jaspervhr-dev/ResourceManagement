package com.itlize.ResourceManagement.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project_columns")
public class ProjectColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer columnId;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "column_name")
    private String columnName;

    private Type type;

    private String formulaText;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "column",cascade = CascadeType.ALL)
    private Set<ResourceDetail> resourceDetailSet;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    public Set<ResourceDetail> getResourceDetailSet() {
        return resourceDetailSet;
    }

    public void setResourceDetailSet(Set<ResourceDetail> resourceDetailSet) {
        this.resourceDetailSet = resourceDetailSet;
    }
}
