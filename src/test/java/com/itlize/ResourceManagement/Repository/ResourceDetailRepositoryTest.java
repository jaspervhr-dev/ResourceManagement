package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siteng Fan
 * @date 9/30/21 3:04 PM
 */
@SpringBootTest
class ResourceDetailRepositoryTest {

    @Autowired
    ProjectColumnRepository projectColumnRepository;

    @Autowired
    ResourceDetailRepository resourceDetailRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void saveTest(){
        ResourceDetail resourceDetail = new ResourceDetail();
        ProjectColumn projectColumn = new ProjectColumn();
        Project project = new Project();
        Resource resource = resourceRepository.findById(2).orElse(null);
        project.setOwner(userRepository.findById("siteng").orElse(null));
        projectColumn.setProject(project);
        resourceDetail.setTimeCreated(LocalDateTime.now());
        resourceDetail.setResource(resource);
        resourceDetail.setColumn(projectColumn);
        System.out.println(resourceDetail);
        projectRepository.save(project);
        projectColumnRepository.save(projectColumn);
        resourceDetailRepository.save(resourceDetail);
        assertNotNull(resourceDetail);
    }

    @Test
    public void deleteTest(){
        ResourceDetail resourceDetail = resourceDetailRepository.findById(1).orElse(null);
        resourceDetailRepository.delete(resourceDetail);
    }

    @Test
    public void findByResourceTest(){
        Resource resource = resourceRepository.findById(2).orElse(null);
        List<ResourceDetail> resourceDetail= resourceDetailRepository.findByResource(resource);
        System.out.println(resourceDetail);
        assertNotNull(resourceDetail);
    }

    @Test
    public void findByColumnTest(){
        ProjectColumn column = projectColumnRepository.findById(3).orElse(null);
        List<ResourceDetail> resourceDetailList = resourceDetailRepository.findByColumn(column);
        System.out.println(resourceDetailList);
        assertNotNull(resourceDetailList);
    }

}