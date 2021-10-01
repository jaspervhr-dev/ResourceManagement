package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.ResourceDetail;
import com.itlize.ResourceManagement.Service.ResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 10:52 AM
 */
@RestController
@RequestMapping(value = "/resourcedetail")
public class ResourceDetailController {


//    @Autowired
//    ResourceDetailService resourceDetailService;
//
//    @GetMapping("/all")
//    public List<ResourceDetail> findAll(){
//        return resourceDetailService.findAll();
//    }
//    @GetMapping("/resource/{id}")
//    public ResourceDetail findByResource(@PathVariable Integer id){
//        return resourceDetailService.findByResource(id);
//    }
//
//    @GetMapping("/column/{id}")
//    public ResourceDetail findByColumn(@PathVariable Integer id){
//        return resourceDetailService.findByColumn(id);
//    }
//
//    @PutMapping("/addOne")
//    public void addOne(@RequestParam("resourceId") Integer resouceId,
//                       @RequestParam("columnId") Integer columnId,
//                       @RequestParam("columnValue") String columnValue){
//        LocalDateTime timeCreated = LocalDateTime.now();
//        ResourceDetail detail = new ResourceDetail();
//        detail.setResource_id(resouceId);
//        detail.setColumnId(columnId);
//        detail.setColumn_value(columnValue);
//        resourceDetailService.addOne(detail);
//    }
}
