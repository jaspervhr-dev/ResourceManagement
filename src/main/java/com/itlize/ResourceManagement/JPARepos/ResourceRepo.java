package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface ResourceRepo<Resource, ID extends Serializable>
        extends PagingAndSortingRepository<Resource, ID>, QueryByExampleExecutor<Resource> {
}
