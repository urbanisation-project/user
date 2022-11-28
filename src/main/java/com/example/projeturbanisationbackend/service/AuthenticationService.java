package com.example.projeturbanisationbackend.service;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.payload.Credentials;

public interface AuthenticationService {
    User findByCredentials(Credentials credentials);
}
