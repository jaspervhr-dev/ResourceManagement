package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.Repository.ProjectRepository;
import com.itlize.ResourceManagement.Repository.UserRepository;
import com.itlize.ResourceManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Project findById(Integer id){
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> findByUser(User user) {
        return projectRepository.findByOwner(user);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project){
        projectRepository.save(project);
        return project;
    }

    @Override
    public Project create(User user){
        if(userRepository.findById(user.getUsername())!= null){
            user = userRepository.findById(user.getUsername()).orElse(null);
            Project newProject = new Project();
            newProject.setOwner(user);
            newProject.setTimeCreated(LocalDateTime.now());
            projectRepository.save(newProject);
            return newProject;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean delete(Project project){
        if(projectRepository.findById(project.getProjectId())!= null){
            projectRepository.delete(projectRepository.findById(project.getProjectId()).orElse(null));
            return true;
        }
        return false;
    }
}
