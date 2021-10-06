package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siteng Fan
 * @date 10/1/21 12:25 PM
 */

@SpringBootTest
class ProjectResourceServiceTest {

    @Autowired
    ProjectResourceService projectResourceService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ResourceService resourceService;

    @Test
    void findAll() {
        List<ProjectResource> projectResourceList = projectResourceService.findAll();
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

    @Test
    void findByProject() {
        Project project = projectService.findById(1);
        List<ProjectResource> projectResourceList = projectResourceService.findByProject(project);
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

    @Test
    void findByResource() {
        Resource resource = resourceService.findOneById(2);
        List<ProjectResource> projectResourceList = projectResourceService.findByResource(resource);
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

    @Test
    void findByProjectAndResource() {
        Resource resource = resourceService.findOneById(2);
        Project project = projectService.findById(1);
        ProjectResource projectResource = projectResourceService.findByProjectAndResource(project,resource);
        System.out.println(projectResource);
        assertNotNull(projectResource);
    }

    @Test
    void create() {
        Resource resource = resourceService.findOneById(1);
        Project project = projectService.findById(1);
        ProjectResource projectResource = projectResourceService.create(project,resource);
        assertNotNull(projectResource);
        System.out.println(projectResource);
    }
}