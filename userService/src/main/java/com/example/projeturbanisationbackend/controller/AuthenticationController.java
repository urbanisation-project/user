package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.payload.Credentials;
import com.example.projeturbanisationbackend.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/")
    public User authenticate(@RequestBody Credentials credentials){
        return authenticationService.findByCredentials(credentials);
    }
}
