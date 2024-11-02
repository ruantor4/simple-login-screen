package com.torquato.simple_login_screen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.torquato.simple_login_screen.service.UserService;


@RestController
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
            boolean authenticated = service.authenticate(username, password);
            if(authenticated){
                return "Login Successfull";
            }else{
                return "Invalid credentials";
            }
        
    }
}
