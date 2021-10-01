package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Entity.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siteng Fan
 * @date 9/30/21 2:49 PM
 */

@SpringBootTest
class ProjectResourceRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Test
    public void saveTest(){
        Project project = projectRepository.findByProjectId(1);
        Resource resource = resourceRepository.findByResourceId(2);
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProject(project);
        projectResource.setResource(resource);
        System.out.println(projectResource);
        projectResourceRepository.save(projectResource);
        assertNotNull(projectResource);
    }

    @Test
    public void findByResourceTest(){
        Resource resource = resourceRepository.findByResourceId(1);
        List<ProjectResource> projectResourceList = projectResourceRepository.findByResource(resource);
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

    @Test
    public void findByProjectTest(){
        Project project = projectRepository.findByProjectId(1);
        List<ProjectResource> projectResourceList = projectResourceRepository.findByProject(project);
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

    @Test
    public void findByResourceAndProjectTest(){
        Project project = projectRepository.findByProjectId(1);
        Resource resource = resourceRepository.findByResourceId(2);
        List<ProjectResource> projectResourceList = projectResourceRepository.findByProjectAndResource(project,resource);
        System.out.println(projectResourceList);
        assertNotNull(projectResourceList);
    }

}