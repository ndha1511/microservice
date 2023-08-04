package com.example.spring_security.controller;

import com.example.spring_security.dto.UserLogin;
import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/create")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserLogin userLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLogin.getUsername(),
                        userLogin.getPassword()));
        if(authentication.isAuthenticated())
            return userService.generateToken(userLogin.getUsername());
        else
            return "invalid access";
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }
}
