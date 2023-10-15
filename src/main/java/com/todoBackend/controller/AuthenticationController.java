package com.todoBackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@Tag(name = "AuthenticationController")
public class AuthenticationController {

    @GetMapping("/user/authenticate")
    public Map<String,String> authenticateUser(){
        Map<String,String> map = new HashMap<>();
        map.put("user","authenticated");
        return map;
    }
}
