package com.v1.tut.custom.controller;

import com.v1.tut.custom.model.UserApiModel;
import com.v1.tut.custom.model.UserDTO;
import com.v1.tut.custom.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomUserController {
    @Autowired
    private CustomUserService userService;

    @GetMapping("/users/v1/list")
    public List<UserDTO> fetchUsersFromApi1() {
        return userService.fetchUsersFromApi1();
    }

    @GetMapping("/users/v11/list")
    public List<UserApiModel> fetchUsersFromApi11() {
        return userService.fetchUsersFromApi11();
    }

    @GetMapping("/users/v2/list")
    public List<UserDTO> fetchUsersFromApi2() {
        return userService.fetchUsersFromApi2();
    }
}
