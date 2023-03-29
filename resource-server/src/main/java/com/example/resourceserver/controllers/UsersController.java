package com.example.resourceserver.controllers;

import com.example.resourceserver.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + environment.getProperty("local.server.port");
    }

    //@Secured("ROLE_developer")
    //@PreAuthorize("hasRole('developer')")
    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Delete user with id " + id + " jwt subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserResponse getUser(@PathVariable("id") String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserResponse("Vivek", "Sharma", "b5d72a58-5ec8-482e-ac9b-6398b1639d0");
    }
}
