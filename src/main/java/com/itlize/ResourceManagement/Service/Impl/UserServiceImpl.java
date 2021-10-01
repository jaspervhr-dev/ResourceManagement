package com.itlize.ResourceManagement.Service.Impl;

import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.Repository.UserRepository;
import com.itlize.ResourceManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository UserRepository;

    @Override
    public User findByUsername(String username) {
        return UserRepository.findById(username).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return UserRepository.findAll();
    }
}
