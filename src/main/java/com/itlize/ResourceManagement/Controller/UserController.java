package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.JPARepos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
