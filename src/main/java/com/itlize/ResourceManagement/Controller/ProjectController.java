package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.*;
import com.itlize.ResourceManagement.Service.*;
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
    UserService userService;

    @Autowired
    ProjectResourceService projectResourceService;

    /**
     * @param projectId
     * @return Project
     */
    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam(name= "projectId") Integer projectId){
        Project currentProject = projectService.findById(projectId);
        if(currentProject == null){
            return new ResponseEntity<>("{error: the resource is not exist}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(currentProject, HttpStatus.OK);
    }

    /**
     * @return list of all Projects
     */
    @GetMapping("/allprojects")
    public ResponseEntity<List<Project>> getProjectList(){
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    /**
     * @return list of all resources
     */
    @GetMapping("/allresources")
    public ResponseEntity<List<Resource>> getResourceList(){
        return new ResponseEntity<>(resourceService.findALl(), HttpStatus.OK);
    }

    /**
     * @param projectId
     * @return list of resources specific to a project
     */
    @GetMapping("/getprojectresources")
    public ResponseEntity<List<?>> getResourcesFromProject(@RequestParam("projectId") Integer projectId){
        List<Resource> resourceList = new ArrayList<>();
        Project currentProject = projectService.findById(projectId);
        if(currentProject == null){
            return new ResponseEntity("{error: invalid projectId}", HttpStatus.BAD_REQUEST);
        }
        Set<ProjectResource> projectResourceSet = currentProject.getProjectResourceSet();
        for(ProjectResource pr : projectResourceSet){
            resourceList.add(pr.getResource());
        }
        return new ResponseEntity<>(resourceList, HttpStatus.OK);
    }

    /**
     * @param resourceIds
     * @param projectId
     * @return a list of the created project-resources
     */
    @PostMapping("/addresources")
    public ResponseEntity<List<?>> addResourcesToProject(@RequestParam(name="resourceIds") List<Integer> resourceIds, @RequestParam("projectId") Integer projectId){
        Project currProject = projectService.findById(projectId);
        if(currProject == null){
            return new ResponseEntity("{error: projectId invalid", HttpStatus.BAD_REQUEST);
        }
        //Get a list of resources from the given ids
        List<Resource> selectedResources = new ArrayList<>();
        boolean validResourceIds = true;
        for(Integer i : resourceIds){
            Resource foundResource = resourceService.findOneById(i);
            if(foundResource == null){
                validResourceIds = false;
            }
            else {
                selectedResources.add(foundResource);
            }
        }
        List<ProjectResource> newProjectResources = new ArrayList<>(); //to hold all created entities and be returned
        for(Resource resource: selectedResources){
            ProjectResource projectResource = projectResourceService.create(currProject, resource);
            newProjectResources.add(projectResource);
        }
        if(!validResourceIds){
            return new ResponseEntity("{warning: one or more of the resourceIds were invalid. All valid resourceIds were added}",HttpStatus.OK);
        }
        return new ResponseEntity<>(newProjectResources, HttpStatus.CREATED);
    }

    /**
     * @param resourceIds
     * @param projectId
     * Removes all selected resources with the given project id from projectResource table
     */
    @DeleteMapping("/removeResources")
    public ResponseEntity removeResourcesFromProject(@RequestParam("resourceIds") List<Integer> resourceIds, @RequestParam("projectId") Integer projectId){
        Project currProject = projectService.findById(projectId);
        if(currProject == null){
            return new ResponseEntity("{error: projectId invalid", HttpStatus.BAD_REQUEST);
        }
        boolean validResourceIds = true;
        List<Resource> selectedResources = new ArrayList<>();
        for(Integer i : resourceIds){
            Resource foundResource = resourceService.findOneById(i);
            if(foundResource == null){
                validResourceIds = false;
            }
            else {
                selectedResources.add(foundResource);
            }
        }
        for(Resource resource: selectedResources){
            ProjectResource projectResource = projectResourceService.findByProjectAndResource(currProject, resource);
            projectResourceService.delete(projectResource);
        }
        if(!validResourceIds){
            return new ResponseEntity("{warning: one or more of the resourceIds were invalid. All valid resourceIds were removed}",HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * @param user
     * Creates a project with a given a user entity
     */
    @PostMapping("/createproject")
    public ResponseEntity<Project> createProject(@RequestBody User user){
        User userFound = userService.findByUsername(user.getUsername());
        if(userFound == null){
            return new ResponseEntity("{error: user not recognized", HttpStatus.BAD_REQUEST);
        }
        Project newProject = projectService.create(userFound);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    /**
     * @param currentProject
     */
    @DeleteMapping("/deleteproject")
    public ResponseEntity deleteProject(@RequestBody Project currentProject){
        if(projectService.delete(currentProject)){ //returns true if successfull
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity("{error: project was not recognized}", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * @param sentProject
     */
    @PostMapping("/saveproject")
    public ResponseEntity<Project> saveProject(@RequestBody Project sentProject){
        Project foundProject = projectService.findById(sentProject.getProjectId());
        if(foundProject == null){
            return new ResponseEntity("{errer: project was not recognized}", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        projectService.save(foundProject);
        return new ResponseEntity<>(foundProject, HttpStatus.OK);
    }

//    TODO: Find a way to send data and redirect simultaneously
//    @PostMapping("/toformula")
//    public ResponseEntity<?> toFormula(@RequestParam("resourceIds") List<Integer> resourceIds, @RequestParam("projectId") Integer projectId){
//

}
