package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;

import java.util.List;
import java.util.Optional;

public interface ProjectColumnService{
    public ProjectColumn findById(Integer id);
    public List<ProjectColumn> findByProject(Project project);
    public ProjectColumn findByProjectAndColumnId(Project project, Integer cid);
    public List<ProjectColumn> findAll();
}
