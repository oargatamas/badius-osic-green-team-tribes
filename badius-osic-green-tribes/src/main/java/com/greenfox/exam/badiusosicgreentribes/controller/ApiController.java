package com.greenfox.exam.badiusosicgreentribes.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping( "/admin/hello" )
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello() {
        return "Hello admin!";
    }

    @GetMapping( "/user/hello" )
    @PreAuthorize("hasRole('PLAYER')")
    public String userHello() {
        return "Hello player!";
    }
}
