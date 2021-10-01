package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsername() {
        User user = userRepository.getById("usertest1");
        //TODO
    }

    @Test
    void findByProjectId() {
        Project project = projectService.findByProjectId(1);
        System.out.println(project);
        assertNotNull(project);
    }

    @Test
    void findAll() {
        List<Project> projects = projectService.findAll();
        assertNotNull(projects);
        assertEquals(projects.size(), 4);
    }
}