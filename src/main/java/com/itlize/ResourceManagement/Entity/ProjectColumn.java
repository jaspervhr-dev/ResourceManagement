package com.itlize.ResourceManagement.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project_columns")
public class ProjectColumn {
    @Id
    @GeneratedValue
    private Integer columnId;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Integer projectId;

    @Column(name = "column_name")
    private String columnName;

    private Type type;

    private String formulaText;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "column",cascade = CascadeType.ALL)
    private Set<ResourceDetail> resourceDetailSet;

    public void setColumn_id(Integer column_id) {
        this.columnId = column_id;
    }

    public void setProject_id(Integer project_id) {
        this.projectId = project_id;
    }

    public void setColumn_name(String column_name) {
        this.columnName = column_name;
    }

    public void setFormula_text(String formula_text) {
        this.formulaText = formula_text;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getColumn_id() {
        return columnId;
    }

    public Integer getProject_id() {
        return projectId;
    }

    public String getColumn_name() {
        return columnName;
    }

    public String getFormula_text() {
        return formulaText;
    }

    public Type getType() {
        return type;
    }
}
