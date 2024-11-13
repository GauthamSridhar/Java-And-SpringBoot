package com.example.TaskManagement.controller;

import com.example.TaskManagement.model.UserModel;
import com.example.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){

        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    @GetMapping
    public List<UserModel> getAll(){
        return userRepo.findAll();
    }

}
