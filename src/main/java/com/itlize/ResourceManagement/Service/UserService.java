package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.User;

import java.util.List;

public interface UserService {
    public User findByUsername(String username);
    public List<User> findAll();
}
