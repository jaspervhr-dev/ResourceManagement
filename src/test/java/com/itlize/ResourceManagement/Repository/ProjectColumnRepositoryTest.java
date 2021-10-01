package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Entity.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectColumnRepositoryTest {

    @Autowired
    ProjectColumnRepository projectColumnRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void saveTest(){
        Project project = projectRepository.findByProjectId(1);
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setColumnId(1);
        projectColumn.setType(Type.number);
        projectColumn.setColumnName("columntest");
        projectColumn.setProject(project);
        projectColumnRepository.save(projectColumn);
        assertNotNull(projectColumn);
    }

    @Test
    void findByProject() {
        Project project = projectRepository.findByProjectId(1);
        List<ProjectColumn> projectColumn = projectColumnRepository.findByProject(project);
        assertEquals(projectColumn.get(0).getColumnName(), "columntest");
    }
}