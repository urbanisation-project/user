package com.example.userService.service;

import com.example.userService.model.Owner;

import java.util.List;

public interface UserService {
    Owner save(Owner user);
    Owner update(Owner user);
    Owner findById(Long userId);
    List<Owner> findAll();
    boolean deleteById(Long userId);
}
