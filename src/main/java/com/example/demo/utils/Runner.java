package com.example.demo.utils;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    private final RoleRepository roleRepository;
    private final UserService userService;

    public Runner(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleRepository.save(new Role(Roles.ADMIN.name()));
        roleRepository.save(new Role(Roles.USER.name()));

       // userService.addUserDTO(new UserDTO())
    }
}
