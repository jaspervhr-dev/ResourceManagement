package com.itlize.ResourceManagement.Repository;

import com.itlize.ResourceManagement.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest(){
        User user = new User();
        user.setUsername("usertest1");
        user.setEmail("emailtest");
        user.setPassword("pwtest");
        user.setRole("roletest");
        user.setPhoneNumber("111111111");
        user.setTitle("titletest");
        user.setTimeCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());
        userRepository.save(user);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void findTest(){
        User user = userRepository.findById("usertest1").orElse(null);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void updateTest(){
        User user=userRepository.findById("usertest1").orElse(null);
        System.out.println(user.toString());
        assertNotNull(user);
        user.setLastUpdated(LocalDateTime.now());
        System.out.println(user);
        userRepository.save(user);
        assertNotNull(user);
    }
}