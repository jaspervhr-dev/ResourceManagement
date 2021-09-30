package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 11:56 AM
 */

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

    public List<ProjectResource> findByProjectId(Integer projectId);

    public List<ProjectResource> findByResourceId(Integer resourceId);

    public List<ProjectResource> findByProjectIdAndAndResourceId(Integer projectID, Integer ResourceID);
}
