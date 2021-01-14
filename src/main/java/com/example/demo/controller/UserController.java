package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

@Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("!hasAuthority('USER')")
    User create(/*@Valid*/ @RequestBody UserDTO userDTO) {
        return userService.addUserDTO(userDTO);
    }
}
