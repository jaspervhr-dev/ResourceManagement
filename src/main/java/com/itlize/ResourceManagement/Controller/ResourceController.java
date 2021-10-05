package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.*;
import com.itlize.ResourceManagement.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Siteng Fan
 * @date 9/29/21 12:01 PM
 */

@RestController
@RequestMapping("resources")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectResourceService projectResourceService;

    @Autowired
    ProjectColumnService projectColumnService;

    @Autowired
    ResourceDetailService resourceDetailService;

    @GetMapping("/all")
    public ResponseEntity<List<Resource>> findAll() {
        List<Resource> resourceList = resourceService.findALl();
        return new ResponseEntity<>(resourceList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> findById(@PathVariable Integer id) {
        Resource resource = resourceService.findOneById(id);

        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity addOne(@RequestParam("resourceName") String resourceName) {
        Resource resource = new Resource();
        resource.setResourceName(resourceName);
        resource.setTimeCreated(LocalDateTime.now());
        resourceService.addOne(resource);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    /***
     * Find All resource in one Project
     * @param id Project ID
     * @return List<Resource></>
     */
    @GetMapping("/project/{id}")
    public ResponseEntity<List<Resource>> findByProject(@PathVariable Integer id) {
        Project project = projectService.findById(id);
        List<ProjectResource> projectResourceList = projectResourceService.findByProject(project);
        List<Resource> resourceList = new ArrayList<>();
        for (ProjectResource pR : projectResourceList) {
            resourceList.add(pR.getResource());
        }
        return new ResponseEntity<List<Resource>>(resourceList,HttpStatus.OK);
    }

    /**
     * this method is used to delete one resource in a project
     */
    @DeleteMapping("/deleteOne")
    public ResponseEntity deleteOneFromProject(@RequestParam Integer projectId,
                                     @RequestParam Integer resourceId) {
        Project project = projectService.findById(projectId);
        List<ProjectResource> projectResourceList = projectResourceService.findByProject(project);
        ProjectResource projectResource = null;
        for (ProjectResource pR : projectResourceList) {
            if (pR.getResource().getResourceId() == resourceId) {
                projectResource = pR;
            }
        }
        projectResourceService.deleteByEntity(projectResource);
        return new ResponseEntity(HttpStatus.OK);
    }

    /***
     * Delete All project-resource in one project
     */
    @DeleteMapping("/deleteAllInProject/{id}")
    public void deleteAllInProject(@PathVariable Integer id) {
        Project project = projectService.findById(id);
        List<ProjectResource> projectResourceList = projectResourceService.findByProject(project);
        projectResourceService.deleteAll(projectResourceList);
    }

    /***
     * Add one Project-Resource depends on projectId and resourceId
     * @param projectId Project ID
     * @param resourceId Resource ID
     */
    @PutMapping("/addProjectResource")
    public ResponseEntity addOneProjectResource(@RequestParam Integer projectId,
                                      @RequestParam Integer resourceId) {
        Project project = projectService.findById(projectId);
        Resource resource = resourceService.findOneById(resourceId);
        projectResourceService.addOne(project, resource);
        return new ResponseEntity(HttpStatus.OK);
    }

    /***
     * add a column for all resources.
     * column = 0 means this column is for all resources
     * @param columnName
     */
    @PutMapping("/addColumn")
    public void addColumnToAllResources(@RequestParam String columnName){
        Project project = projectService.findById(0);
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setProject(project);
        projectColumn.setColumnName(columnName);
        projectColumnService.addOne(projectColumn);
    }

    @PutMapping("/addColumnValue")
    public ResponseEntity addColumnValueToResource(@RequestParam String columnValue,
                                         @RequestParam Integer projectId,
                                         @RequestParam Integer resourceId,
                                         @RequestParam String ColumnName){
        Project project = projectService.findById(projectId);
        Resource resource = resourceService.findOneById(resourceId);
        List<ProjectColumn> projectColumnList = projectColumnService.findByProject(project);
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setResource(resource);
        for(ProjectColumn projectColumn:projectColumnList){
            if (Objects.equals(projectColumn.getColumnName(), ColumnName)){
                resourceDetail.setColumn(projectColumn);
            }
        }
        resourceDetailService.addOne(resourceDetail);
        return new ResponseEntity(HttpStatus.OK);
    }

    /***
     * update a column value for a column of all resources
     * @param columnValue The value of this column
     * @param columnName The name of this column
     * @param resourceId Resource ID which this column belongs to
     */
    @PutMapping("/updateColumnValue")
    public void updateColumnValue(@RequestParam String columnValue,
                                  @RequestParam String columnName,
                                  @RequestParam Integer resourceId){
        Resource resource = resourceService.findOneById(resourceId);
        Set<ResourceDetail> resourceDetailSet = resource.getResourceDetailSet();
        for (ResourceDetail resourceDetail:resourceDetailSet){
            if(resourceDetail.getColumn().getColumnId()==0&&resourceDetail.getColumn().getColumnName()==columnName){
                resourceDetail.setColumnValue(columnValue);
                resourceDetailService.addOne(resourceDetail);
            }
        }
    }

}