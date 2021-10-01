package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 11:56 AM
 */


public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {
  
    public List<ProjectResource> findByProject(Project project);

    public List<ProjectResource> findByResource(Resource resource);

    public List<ProjectResource> findByProjectAndResource(Project project, Resource Resource);
}
