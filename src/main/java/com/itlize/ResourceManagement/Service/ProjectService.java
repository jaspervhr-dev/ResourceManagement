package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;

import java.util.List;

public interface ProjectService {
    public Project findById(Integer id);
    public List<Project> findByUsername(User user);
    public List<Project> findAll();
}
