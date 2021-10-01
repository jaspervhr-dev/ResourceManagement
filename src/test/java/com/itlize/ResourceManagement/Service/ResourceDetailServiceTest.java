package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Entity.ResourceDetail;
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
class ResourceDetailServiceTest {
    @Autowired
    ResourceDetailService resourceDetailService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    ProjectColumnService projectColumnService;

    @Test
    public void saveTest(){
        ResourceDetail resourceDetail = new ResourceDetail();
        Resource resource = resourceService.findOneById(1);
        ProjectColumn projectColumn=projectColumnService.findById(3);
        resourceDetail.setResource(resource);
        resourceDetail.setColumn(projectColumn);
        resourceDetailService.addOne(resourceDetail);
        assertNotNull(resourceDetail);
    }

    @Test
    public void findAllTest(){
        List<ResourceDetail> resourceDetailList = resourceDetailService.findAll();
        System.out.println(resourceDetailList);
        assertNotNull(resourceDetailList);
    }

    @Test
    public void findByResourceTest(){
        Resource resource = resourceService.findOneById(1);
        List<ResourceDetail> resourceDetailList = resourceDetailService.findByResource(resource);
        System.out.println(resourceDetailList);
        assertNotNull(resourceDetailList);
    }

    @Test
    public void findByColumnTest(){
        ProjectColumn projectColumn = projectColumnService.findById(3);
        List<ResourceDetail> resourceDetailList = resourceDetailService.findByColumn(projectColumn);
        System.out.println(resourceDetailList);
        assertNotNull(resourceDetailList);
    }

}