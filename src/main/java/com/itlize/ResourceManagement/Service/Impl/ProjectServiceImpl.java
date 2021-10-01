package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.Repository.ProjectRepository;
import com.itlize.ResourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findByUsername(User user) {
        return projectRepository.findByOwner(user);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

}
