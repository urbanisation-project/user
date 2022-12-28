package com.example.userService.service;

import com.example.userService.model.Owner;
import com.example.userService.payload.Credentials;

public interface AuthenticationService {
    Owner findByCredentials(Credentials credentials);
}
