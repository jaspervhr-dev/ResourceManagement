package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.Project;
import com.itlize.ResourceManagement.Entity.ProjectColumn;
import com.itlize.ResourceManagement.Repository.ProjectColumnRepository;
import com.itlize.ResourceManagement.Service.ProjectColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectColumnServiceImpl implements ProjectColumnService {

    @Autowired
    ProjectColumnRepository projectColumnRepository;

    @Override
    public ProjectColumn findById(Integer id){
        return projectColumnRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectColumn> findByProject(Project project) {
        return projectColumnRepository.findByProject(project);
    }

    @Override
    public List<ProjectColumn> findAll() {
        return projectColumnRepository.findAll();
    }

    @Override
    public void addOne(ProjectColumn projectColumn) {
        projectColumnRepository.save(projectColumn);
    }

    @Override
    public void deleteOne(ProjectColumn projectColumn) {
        projectColumnRepository.delete(projectColumn);
    }

    @Override
    public ProjectColumn findByProjectAndColumnId(Project project, Integer cid){
        return projectColumnRepository.findByProjectAndColumnId(project, cid);
    }
}
