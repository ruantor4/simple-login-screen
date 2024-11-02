package com.torquato.simple_login_screen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.simple_login_screen.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    public UserRepository repository;

    public boolean authenticate(String username, String password){
            return repository.findByUsername(username)
            .map(user -> user.getPassword().equals(password))
            .orElse(false);

    }
    
}
