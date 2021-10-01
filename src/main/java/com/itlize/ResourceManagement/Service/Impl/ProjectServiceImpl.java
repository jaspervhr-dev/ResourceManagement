package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Repository.ProjectRepository;
import com.itlize.ResourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findByUsername(String username) {
        return projectRepository.findByUsername(username);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findByProjectId(Integer id){
        return projectRepository.findByProjectId(id);
    }
}
