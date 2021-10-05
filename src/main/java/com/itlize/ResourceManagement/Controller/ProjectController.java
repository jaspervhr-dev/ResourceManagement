package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.*;
import com.itlize.ResourceManagement.Service.ProjectColumnService;
import com.itlize.ResourceManagement.Service.ProjectResourceService;
import com.itlize.ResourceManagement.Service.ProjectService;
import com.itlize.ResourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Jasper Rodgers
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectColumnService projectColumnService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    ProjectResourceService projectResourceService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Integer id){
        Project currentProject = projectService.findById(id);
        return new ResponseEntity<>(currentProject, HttpStatus.OK);
    }

    @GetMapping("/allprojects")
    public ResponseEntity<List<Project>> getProjectList(){
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/allresources")
    public ResponseEntity<List<Resource>> getResourceList(){
        return new ResponseEntity<>(resourceService.findALl(), HttpStatus.OK);
    }

    @GetMapping("/getprojectresources")
    public ResponseEntity<List<Resource>> getResourcesFromProject(@RequestBody Project currentProject){
        List<Resource> resourceList = new ArrayList<>();
        Set<ProjectResource> projectResourceSet = currentProject.getProjectResourceSet();
        for(ProjectResource pr : projectResourceSet){
            resourceList.add(pr.getResource());
        }
        return new ResponseEntity<>(resourceList, HttpStatus.OK);
    }

    @GetMapping("/projectcolumns")
    public ResponseEntity<List<ProjectColumn>> getPCList(@RequestBody Project currentProject){
        return new ResponseEntity<>(projectColumnService.findByProject(currentProject), HttpStatus.OK);
    }

    @PostMapping("/addresources")
    public ResponseEntity<List<ProjectResource>> addResourcesToProject(@RequestBody List<Resource> selectedResources, @RequestBody Project currProject){
        List<ProjectResource> newProjectResources = new ArrayList<>();
        for(Resource resource: selectedResources){
            ProjectResource projectResource = projectResourceService.create(currProject, resource);
            newProjectResources.add(projectResource);
        }
        return new ResponseEntity<>(newProjectResources, HttpStatus.OK);
    }

    @DeleteMapping("/removeResources")
    public ResponseEntity removeResourcesFromProject(@RequestBody List<Resource> selectedResources, @RequestBody Project currProject){
        for(Resource resource: selectedResources){
            ProjectResource projectResource = projectResourceService.findByProjectAndResource(currProject, resource);
            projectResourceService.delete(projectResource);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/createproject")
    public ResponseEntity<Project> createProject(@RequestBody User user){
        Project newProject = projectService.create(user);
        return new ResponseEntity<>(newProject, HttpStatus.OK);
    }

    @DeleteMapping("/deleteproject")
    public ResponseEntity deleteProject(@RequestBody Project currentProject){
        if(projectService.delete(currentProject)){ //returns true if successfull
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PostMapping("/saveproject")
    public ResponseEntity<Project> saveProject(@RequestBody Project currentProject){
        projectService.save(currentProject);
        return new ResponseEntity<>(currentProject, HttpStatus.OK);
    }

//    @PostMapping("/toformula")
//    TODO Not sure how to send data to different controller yet

}
