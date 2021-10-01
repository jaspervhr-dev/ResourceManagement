package com.itlize.ResourceManagement.Service;

import com.itlize.ResourceManagement.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void findByUsername() {
        User user = userService.findByUsername("usertest1");
        assertNotNull(user);
        assertEquals(user.getEmail(), "emailtest");
    }

    @Test
    void findAll() {
        List<User> users = userService.findAll();
        assertNotNull(users);
        //number of users in db
        assertEquals(users.size(), 2);
    }
}