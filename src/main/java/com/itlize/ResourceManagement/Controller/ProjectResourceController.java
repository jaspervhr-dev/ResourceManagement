package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.ProjectResource;
import com.itlize.ResourceManagement.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 12:03 PM
 */
@RestController
@RequestMapping("/projectresource")
public class ProjectResourceController {

//    @Autowired
//    ProjectResourceService service;
//
//    public List<ProjectResource> findAll(){
//        return service.findAll();
//    }
//
//    public List<ProjectResource> findByProject(@RequestParam("projectId") Integer id){
//        return service.findByProject(id);
//    }
//
//    public List<ProjectResource> findByResource(@RequestParam("resourceId") Integer id){
//        return service.findByResource(id);
//    }
}

