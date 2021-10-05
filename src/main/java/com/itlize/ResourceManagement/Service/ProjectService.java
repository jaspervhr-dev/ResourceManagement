package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;

import java.util.List;

public interface ProjectService {
    public Project findById(Integer id);
    public List<Project> findByUser(User user);
    public List<Project> findAll();
    public Project save(Project project);
    public Project create(User user);
    public boolean delete(Project project);
}
