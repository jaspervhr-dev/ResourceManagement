package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.ProjectColumn;

import java.util.List;
import java.util.Optional;

public interface ProjectColumnService{
    public Optional<ProjectColumn> findByColumnId(Integer cid);
    public List<ProjectColumn> findByProject(Integer pid);
    public ProjectColumn findByProjectAndColumnId(Integer pid, Integer cid);
    public List<ProjectColumn> findAll();

}
