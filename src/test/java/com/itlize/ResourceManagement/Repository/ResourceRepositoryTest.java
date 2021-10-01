package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siteng Fan
 * @date 9/30/21 2:52 PM
 */

@SpringBootTest
class ResourceRepositoryTest {

    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void saveTest(){
        Resource resource = new Resource();
        resource.setResourceName("TestResource1");
        resource.setTimeCreated(LocalDateTime.now());
        resourceRepository.save(resource);
        System.out.println(resource.getResourceName());
        assertNotNull(resource);
    }

    @Test
    public void findTest(){
        Resource resource = resourceRepository.findById(1).orElse(null);
        System.out.println(resource);
        assertNotNull(resource);
    }

    @Test
    public void updateTest(){
        Resource resource=resourceRepository.findById(1).orElse(null);
        System.out.println(resource);
        assertNotNull(resource);
        resource.setLastUpdated(LocalDateTime.now());
        System.out.println(resource);
        resourceRepository.save(resource);
        assertNotNull(resource);
    }

}