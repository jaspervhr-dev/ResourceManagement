package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectColumnServiceTest {

    @Autowired
    ProjectColumnService projectColumnService;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void findByProject() {
        Project project = projectRepository.findById(1).orElse(null);
        List<ProjectColumn> projectColumns = projectColumnService.findByProject(project);
        assertNotNull(projectColumns);
    }

    @Test
    void findByProjectAndColumnId() {
        Project project = projectRepository.findById(1).orElse(null);
        ProjectColumn projectColumns = projectColumnService.findByProjectAndColumnId(project, 1);
        assertNotNull(projectColumns);
    }

    @Test
    void findAll() {
        List<ProjectColumn> projectColumns = projectColumnService.findAll();
        assertNotNull(projectColumns);
    }
}