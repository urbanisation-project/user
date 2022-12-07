package com.example.userService.service;

import com.example.userService.model.User;
import com.example.userService.payload.Credentials;

public interface AuthenticationService {
    User findByCredentials(Credentials credentials);
}
