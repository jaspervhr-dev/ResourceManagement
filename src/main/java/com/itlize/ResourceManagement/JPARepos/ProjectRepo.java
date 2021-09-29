package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface ProjectRepo<Project, ID extends Serializable>
        extends PagingAndSortingRepository<Project, ID>, QueryByExampleExecutor<Project> {
}
