package com.example.projeturbanisationbackend.service.impl;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.repository.UserRepository;
import com.example.projeturbanisationbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> findAll() {
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
