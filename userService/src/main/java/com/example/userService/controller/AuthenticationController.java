package com.example.userService.controller;

import com.example.userService.payload.Credentials;
import com.example.userService.payload.UserPayload;
import com.example.userService.service.AuthenticationService;
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
    public UserPayload authenticate(@RequestBody Credentials credentials){
        return authenticationService.findByCredentials(credentials).toPayload();
    }
}
