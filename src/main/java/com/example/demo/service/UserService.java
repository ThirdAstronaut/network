package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService{

    Optional<User> findByUsername(String username);
    User addUserDTO(UserDTO userDTO);


}
