package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Repository.ResourceRepository;
import com.itlize.ResourceManagement.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/29/21 11:45 AM
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public Resource findOneById(Integer id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Resource> findALl() {
        return resourceRepository.findAll();
    }
}
