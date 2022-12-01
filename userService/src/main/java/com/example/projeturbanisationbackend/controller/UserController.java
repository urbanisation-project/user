package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.payload.UserPayload;
import com.example.projeturbanisationbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/save")
    public UserPayload save(@RequestBody UserPayload userPayload){
        return userService.save(userPayload.toEntity()).toPayload();
    }
    @PostMapping("/update")
    public UserPayload update(@RequestBody UserPayload userPayload){
        return userService.update(userPayload.toEntity()).toPayload();
    }
    @GetMapping("/{userId}")
    public UserPayload findById(@PathVariable Long userId){
        return userService.findById(userId).toPayload();
    }
    @GetMapping("/")
    public List<UserPayload> getAll(){
        return userService.findAll().stream().map(User::toPayload).collect(Collectors.toList());
    }
    @DeleteMapping("/{userId}")
    public boolean deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }
}
