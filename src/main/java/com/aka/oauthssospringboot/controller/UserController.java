package com.aka.oauthssospringboot.controller;

import com.aka.oauthssospringboot.model.UserEntity;
import com.aka.oauthssospringboot.model.dto.UserDTO;
import com.aka.oauthssospringboot.service.IUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserDetailsService userDetailsService;

    public UserController(IUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody UserDTO userDTO) {
        logger.info("Creating new user: {}", userDTO.getEmail());

        if (userDetailsService.findUserByEmail(userDTO.getEmail()) != null) {
            logger.warn("User already exists: {}", userDTO.getEmail());
            return ResponseEntity.badRequest().body("User already exists");
        }

        UserEntity userEntity = convertToEntity(userDTO);
        userDetailsService.createNewUser(userEntity);

        logger.info("User created successfully: {}", userDTO.getEmail());
        return ResponseEntity.ok("User created successfully");
    }


    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, @Valid @RequestBody UserDTO userDTO) {
        logger.info("Updating user: {}", email);

        UserEntity existingUser = userDetailsService.findUserByEmail(email);
        if (existingUser == null) {
            logger.warn("User not found: {}", email);
            return ResponseEntity.badRequest().body("User not found");
        }

        existingUser.setName(userDTO.getName());
        existingUser.setPasswordHash(userDTO.getPassword());
        userDetailsService.updateUser(existingUser);

        logger.info("User updated successfully: {}", email);
        return ResponseEntity.ok("User updated successfully");
    }


    private UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setName(userDTO.getName());
        userEntity.setPasswordHash(userDTO.getPassword());
        return userEntity;
    }
}

