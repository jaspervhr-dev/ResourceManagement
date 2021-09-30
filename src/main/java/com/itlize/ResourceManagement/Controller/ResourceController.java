package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/29/21 12:01 PM
 */

@RestController
@RequestMapping("resources")
public class ResourceController {

    @Autowired
    ResourceService service;

    @GetMapping("/all")
    public List<Resource> findAll(){
        return service.findALl();
    }

    @GetMapping("/{id}")
    public Resource findById(@PathVariable Integer id){
        return service.findOneById(id);
    }
}