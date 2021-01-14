package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signin")
public class SignInController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public SignInController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signin(@RequestParam String email, @RequestParam String password) {
        return userService.addUserDTO(new UserDTO(email, passwordEncoder.encode(password)));
    }
/*
    @PostMapping("/validateEmail")
    Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }*/

}