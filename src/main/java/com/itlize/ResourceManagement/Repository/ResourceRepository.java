package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Siteng Fan
 * @date 9/29/21 11:41 AM
 */

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    public Resource findByResourceId(Integer id);
}
