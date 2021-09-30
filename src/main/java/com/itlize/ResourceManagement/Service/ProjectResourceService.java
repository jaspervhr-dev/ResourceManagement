package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.ProjectResource;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 11:57 AM
 */
public interface ProjectResourceService {
    public List<ProjectResource> findAll();

    public List<ProjectResource> findByProject(Integer projectId);

    public List<ProjectResource> findByResource(Integer resourceId);
}
