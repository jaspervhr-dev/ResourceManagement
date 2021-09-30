package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface ProjectResourceRepo<ProjectResource, ID extends Serializable>
        extends PagingAndSortingRepository<ProjectResource, ID>, QueryByExampleExecutor<ProjectResource> {
}
