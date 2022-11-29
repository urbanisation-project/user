package com.example.projeturbanisationbackend.service;

import com.example.projeturbanisationbackend.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    User findById(Long userId);
    List<User> findAll();
    boolean deleteById(Long userId);
}
