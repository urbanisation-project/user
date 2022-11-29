package com.example.projeturbanisationbackend.service.impl;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.payload.Credentials;
import com.example.projeturbanisationbackend.repository.UserRepository;
import com.example.projeturbanisationbackend.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByCredentials(Credentials credentials) {
        return userRepository.findByEmailAndPassword(credentials.getMail(), credentials.getPassword());
    }
}
