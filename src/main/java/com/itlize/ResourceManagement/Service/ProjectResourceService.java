package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Entity.Resource;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 11:57 AM
 */
public interface ProjectResourceService {
    public List<ProjectResource> findAll();

    public List<ProjectResource> findByProject(Project project);

    public List<ProjectResource> findByResource(Resource resource);

    public void deleteByEntity(ProjectResource projectResource);

    public void deleteAll(List<ProjectResource> projectResourceList);

    public void addOne(Project project, Resource resource);

    public ProjectResource findByProjectAndResource(Project project, Resource resource);

    public ProjectResource save(ProjectResource pr);

    public ProjectResource create(Project project, Resource resource);

    public void delete(ProjectResource pr);
}
