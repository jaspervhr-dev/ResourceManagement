package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Repository.ProjectResourceRepository;
import com.itlize.ResourceManagement.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 12:04 PM
 */
@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Override
    public List<ProjectResource> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProjectResource> findByProject(Integer projectId) {
        return repository.findByProjectId(projectId);
    }

    @Override
    public List<ProjectResource> findByResource(Integer resourceId) {
        return repository.findByResourceId(resourceId);
    }
}
