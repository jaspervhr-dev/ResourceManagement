package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Entity.Resource;
import com.itlize.ResourceManagement.Entity.ResourceDetail;

import java.util.List;

/**
 * @author Siteng Fan
 * @date 9/30/21 10:10 AM
 */

public interface ResourceDetailService {
    public List<ResourceDetail> findAll();

    public ResourceDetail findByResource(Resource resourceId);

    public ResourceDetail findByColumn(ProjectColumn columnId);

    public void addOne(ResourceDetail resourceDetail);
}
