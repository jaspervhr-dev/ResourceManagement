package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Entity.ResourceDetail;
import com.itlize.ResourceManagement.Repository.ResourceDetailRepository;
import com.itlize.ResourceManagement.Service.ResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 10:44 AM
 */
@Service
public class ResourceDetailServiceImpl implements ResourceDetailService {

    @Autowired
    ResourceDetailRepository repository;

    @Override
    public List<ResourceDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ResourceDetail> findByResource(Resource resource) {
        return repository.findByResource(resource);
    }

    @Override
    public List<ResourceDetail> findByColumn(ProjectColumn column) {
        return repository.findByColumn(column);
    }

    @Override
    public void addOne(ResourceDetail resourceDetail){
        repository.save(resourceDetail);
    }
}
