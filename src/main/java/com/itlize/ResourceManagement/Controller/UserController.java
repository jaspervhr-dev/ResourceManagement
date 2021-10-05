package com.itlize.ResourceManagement.Controller;

import com.itlize.ResourceManagement.Entity.User;
import com.itlize.ResourceManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jasper Rodgers
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password){
        List<User> users = userService.findAll();
        User userWithMatchingUsername = null;
        for(User u : users){
            if(u.getUsername().equals(username)){
                userWithMatchingUsername = u;
            }
        }
        //If the password matches
        //TODO get encrypted password
        return new ResponseEntity<>(userWithMatchingUsername, HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<User> signUp(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phone", required = false) String phoneNumber,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "role", required = false) String role){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setTitle(title);
        user.setRole(role);
        user.setTimeCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
        //TODO redirect to resource page
    }

    @GetMapping("/userinformation")
    public ResponseEntity<User> viewUserInfo(@RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/updateuserinfo")
    public ResponseEntity<User> updateUserInfo(@RequestBody User currentUser){
        if(currentUser.getEmail()!=""){currentUser.setEmail(currentUser.getEmail());}
        if(currentUser.getPhoneNumber()!=""){currentUser.setPhoneNumber(currentUser.getPhoneNumber());}
        if(currentUser.getTitle()!=""){currentUser.setTitle(currentUser.getTitle());}
        if(currentUser.getRole()!=""){currentUser.setRole(currentUser.getRole());}
        if(currentUser.getUsername()!=""){currentUser.setUsername(currentUser.getUsername());}
        if(currentUser.getPassword()!=""){currentUser.setPassword(currentUser.getPassword());}
        userService.save(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity deleteUser(User user){
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
