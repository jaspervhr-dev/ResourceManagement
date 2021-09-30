package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 11:56 AM
 */
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

    public List<ProjectResource> findByProjectId(Integer projectId);

    public List<ProjectResource> findByResourceId(Integer resourceId);
}
