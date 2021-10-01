package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siteng Fan
 * @date 9/30/21 9:22 PM
 */

@SpringBootTest
class ResourceServiceTest {

    @Autowired
    ResourceService resourceService;

    @Test
    public void findByIdTest(){
        Resource resource = resourceService.findOneById(1);
        System.out.println(resource);
        assertNotNull(resource);
    }

    @Test
    public void findAllTest(){
        List<Resource> resources = resourceService.findALl();
        System.out.println(resources);
        assertNotNull(resources);
    }

    @Test
    public void saveTest(){
        Resource resource = new Resource();
        resource.setResourceName("testService");
        resource.setTimeCreated(LocalDateTime.now());
        resourceService.addOne(resource);
    }
}