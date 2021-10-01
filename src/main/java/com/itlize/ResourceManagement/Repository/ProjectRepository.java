package com.itlize.ResourceManagement.Repository;
import com.itlize.ResourceManagement.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findByUsername(String username);
    public Project findByProjectId(Integer id);
}
