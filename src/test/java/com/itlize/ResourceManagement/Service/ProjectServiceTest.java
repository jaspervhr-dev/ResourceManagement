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
    void findByUser() {
        User user = userRepository.getById("usertest2");
        List<Project> projects = projectService.findByUser(user);
        assertNotNull(projects);
        assertEquals(projects.size(), 4);
    }

    @Test
    void findAll() {
        List<Project> projects = projectService.findAll();
        assertNotNull(projects);
        assertEquals(projects.size(), 5);
    }

    @Test
    void findById(){
        Project project = projectService.findById(1);
        assertNotNull(project);
    }

    @Test
    void create(){
        User user = userRepository.getById("jasper");
        Project project = projectService.create(user);
        assertNotNull(project);
    }

    @Test
    void save(){
        Project project = projectService.findById(1);
        project.setProjectName("update_name_test");
        projectService.save(project);
    }

//    @Test
//    void delete(){
//        Project project = projectService.findById()
//    }
}