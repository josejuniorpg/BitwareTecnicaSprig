package com.BitwareTecnicaF.BitwareTecnicaF.users.controllers;

import com.BitwareTecnicaF.BitwareTecnicaF.users.models.User;
import com.BitwareTecnicaF.BitwareTecnicaF.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
