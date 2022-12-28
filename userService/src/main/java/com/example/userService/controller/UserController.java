package com.example.userService.controller;

import com.example.userService.model.Owner;
import com.example.userService.payload.UserPayload;
import com.example.userService.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public UserPayload save(@RequestBody UserPayload userPayload){
        return userService.save(userPayload.toEntity()).toPayload();
    }
    @PutMapping ("/update")
    public UserPayload update(@RequestBody UserPayload userPayload){
        return userService.update(userPayload.toEntity()).toPayload();
    }
    @GetMapping("/{userId}")
    public UserPayload findById(@PathVariable Long userId){
        return userService.findById(userId).toPayload();
    }
    @GetMapping("/")
    public List<UserPayload> getAll(){
        return userService.findAll().stream().map(Owner::toPayload).collect(Collectors.toList());
    }
    @DeleteMapping("/{userId}/delete")
    public boolean deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }
}
