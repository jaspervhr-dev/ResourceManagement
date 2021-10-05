package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;

import java.util.List;

public interface ProjectColumnService{
    public ProjectColumn findById(Integer id);
    public List<ProjectColumn> findByProject(Project project);
    public ProjectColumn findByProjectAndColumnId(Project project, Integer cid);
    public List<ProjectColumn> findAll();
    public void addOne(ProjectColumn projectColumn);
    public void deleteOne(ProjectColumn projectColumn);
}
