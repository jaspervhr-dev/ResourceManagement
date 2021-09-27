package com.itlize.ResourceManagement.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProjectColumn {
    @Id
    @GeneratedValue
    private Integer column_id;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Integer project_id;

    private String column_name;

    private Type type;

    private String formula_text;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project_column",cascade = CascadeType.ALL)
    private Set<ResourceDetail> resourceDetailSet;

    public void setColumn_id(Integer column_id) {
        this.column_id = column_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public void setFormula_text(String formula_text) {
        this.formula_text = formula_text;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getColumn_id() {
        return column_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public String getColumn_name() {
        return column_name;
    }

    public String getFormula_text() {
        return formula_text;
    }

    public Type getType() {
        return type;
    }
}
