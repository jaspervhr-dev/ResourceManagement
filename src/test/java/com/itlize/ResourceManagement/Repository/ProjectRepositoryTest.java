package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest(){
        Project project = new Project();
        User user = new User();
        user.setUsername("usertest2"); user.setEmail("emailtest2"); user.setPassword("pwtest2"); user.setRole("roletest2"); user.setPhoneNumber("22222222"); user.setTitle("titletest2"); user.setTimeCreated(LocalDateTime.now()); user.setLastUpdated(LocalDateTime.now());
        userRepository.save(user);
        project.setProjectName("projecttest");
        project.setOwner(user);
        project.setTimeCreated(LocalDateTime.now());
        projectRepository.save(project);
        System.out.println(project);
        assertNotNull(project);
    }

    @Test
    void findByOwner() {
        User user = userRepository.getById("usertest2");
        List<Project> projects = projectRepository.findByOwner(user);
        assertNotNull(projects);
    }

    @Test
    void findByProjectId() {
        Project project = projectRepository.findByProjectId(1);
        assertNotNull(project);
        assertEquals(project.getProjectName(), "projecttest");
    }
}