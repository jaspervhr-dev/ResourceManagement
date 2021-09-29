package com.itlize.ResourceManagement.JPARepos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;

public interface UserRepo<User, ID extends Serializable>
        extends PagingAndSortingRepository<User, ID>, QueryByExampleExecutor<User> {
}