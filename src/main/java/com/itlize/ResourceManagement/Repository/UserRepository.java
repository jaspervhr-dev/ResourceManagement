package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jasper
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
