package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Resource;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/29/21 11:43 AM
 */
public interface ResourceService {

    public Resource findOneById(Integer id);

    public List<Resource> findALl();

    public void addOne(Resource resource);

}
