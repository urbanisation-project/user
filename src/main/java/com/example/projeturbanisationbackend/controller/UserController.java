package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId){
        return userService.findById(userId);
    }
    @GetMapping("/")
    public List<User> getAll(){
        return userService.findAll();
    }
    @DeleteMapping("/{userId}")
    public boolean deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }
}
