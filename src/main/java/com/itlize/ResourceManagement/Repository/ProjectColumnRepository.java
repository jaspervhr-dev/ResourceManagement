package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Integer> {
    public List<ProjectColumn> findByProject(Project project);
    public ProjectColumn findByProjectAndColumnId(Project project, Integer columnId);
}
