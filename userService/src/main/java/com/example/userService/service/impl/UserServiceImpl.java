package com.example.userService.service.impl;

import com.example.userService.model.Owner;
import com.example.userService.repository.UserRepository;
import com.example.userService.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Owner save(Owner user) {
        return userRepository.save(user);
    }

    @Override
    public Owner update(Owner user) {
        return userRepository.save(user);
    }

    @Override
    public Owner findById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<Owner> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
