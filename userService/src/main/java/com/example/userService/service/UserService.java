package com.example.userService.service;

import com.example.userService.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    User findById(Long userId);
    List<User> findAll();
    boolean deleteById(Long userId);
}
