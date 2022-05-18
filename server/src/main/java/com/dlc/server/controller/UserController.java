package com.dlc.server.controller;

import com.dlc.server.model.User;
import com.dlc.server.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/:email")
    public UserDetails getUserByEmail(String email) {
        return userDetailsService.loadUserByEmail(email);
    }

    @GetMapping("/:displayName")
    public UserDetails getUserByDisplayName(String displayName) {
        return userDetailsService.loadUserByUsername(displayName);
    }

    @PostMapping("/add")
    public void addUser(User user) {
        userDetailsService.createUser(user);
    }

    @DeleteMapping("/delete/:user")
    public void deleteUser(User user) {
        userDetailsService.deleteUser(user);
    }

    @PutMapping("/update/:user")
    public void updateUser(User user) {
        userDetailsService.updateUser(user);
    }
}
