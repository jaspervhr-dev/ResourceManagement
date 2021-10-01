package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> findByUsername(String username);
    public Project findByProjectId(Integer id);
    public List<Project> findAll();
}
