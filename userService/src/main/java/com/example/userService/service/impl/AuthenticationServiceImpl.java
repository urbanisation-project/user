package com.example.userService.service.impl;

import com.example.userService.model.Owner;
import com.example.userService.payload.Credentials;
import com.example.userService.repository.UserRepository;
import com.example.userService.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Owner findByCredentials(Credentials credentials) {
        return userRepository.findByEmailAndPassword(credentials.getMail(), credentials.getPassword());
    }
}
