package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Repository.ProjectResourceRepository;
import com.itlize.ResourceManagement.Repository.ResourceRepository;
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
    ProjectResourceRepository projectResourceRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Override
    public List<ProjectResource> findAll() {
        return projectResourceRepository.findAll();
    }

    @Override
    public List<ProjectResource> findByProject(Project project) {
        return projectResourceRepository.findByProject(project);
    }

    @Override
    public List<ProjectResource> findByResource(Resource resource) {
        return projectResourceRepository.findByResource(resource);
    }

    @Override
    public List<ProjectResource> findByProjectAndResource(Project project, Resource resource) {
        return projectResourceRepository.findByProjectAndResource(project,resource);
    }
}
