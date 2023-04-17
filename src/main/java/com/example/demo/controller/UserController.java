package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("/post")
    public void insertUser(User user) {
        userService.insert(user);
    }

    @PostMapping("/update/{id}")
    public void updateUser(@PathVariable("id") int id, String name, String email) {
        User updateUser = userService.findById(id);
        updateUser.setName(name);
        updateUser.setEmail(email);
        userService.update(updateUser);
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
