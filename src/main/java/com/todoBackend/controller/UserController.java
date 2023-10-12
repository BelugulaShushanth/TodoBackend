package com.todoBackend.controller;

import com.todoBackend.model.User;
import com.todoBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user/addUser")
    public User createUser(@RequestBody User user){
       return userRepository.save(user);
    }

}
