package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Entity.ResourceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Siteng Fan
 * @date 9/30/21 10:08 AM
 */

@Repository
public interface ResourceDetailRepository extends JpaRepository<ResourceDetail,Integer> {

    public ResourceDetail findByColumnId(Integer columnId);

    public ResourceDetail findByResourceId(Integer resourceId);
}
