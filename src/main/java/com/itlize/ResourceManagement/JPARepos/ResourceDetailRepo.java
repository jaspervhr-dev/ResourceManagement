package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface ResourceDetailRepo<ResourceDetail, ID extends Serializable>
        extends PagingAndSortingRepository<ResourceDetail, ID>, QueryByExampleExecutor<ResourceDetail> {
}