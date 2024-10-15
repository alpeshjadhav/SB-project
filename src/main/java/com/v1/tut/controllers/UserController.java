package com.v1.tut.controllers;

import com.v1.tut.model.UserDTO;
import com.v1.tut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/unique")
    public List<UserDTO> getUniqueUsers() {
        return userService.getUniqueUsers();
    }

    @GetMapping("/users/created-today")
    public List<UserDTO> getUsersCreatedToday() {
        return userService.getUsersCreatedToday();
    }

    @GetMapping("/users/updated-today")
    public List<UserDTO> getUsersUpdatedToday() {
        return userService.getUsersUpdatedToday();
    }
}
