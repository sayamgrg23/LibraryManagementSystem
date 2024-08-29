package com.youtubesb.librarymanagementsystem.Controller;

import com.youtubesb.librarymanagementsystem.Entity.UserEntity;
import com.youtubesb.librarymanagementsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.save(user);
    }
}
