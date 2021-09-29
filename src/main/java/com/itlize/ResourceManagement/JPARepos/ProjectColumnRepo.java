package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface ProjectColumnRepo<ProjectColumn, ID extends Serializable>
        extends PagingAndSortingRepository<ProjectColumn, ID>, QueryByExampleExecutor<ProjectColumn> {
}
