package com.example.spring_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping("/admin")
    // ROLE_(my role)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String admin() {
        return "Hello admin";
    }
}
