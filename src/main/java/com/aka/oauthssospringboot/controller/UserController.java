package com.aka.oauthssospringboot.controller;

import com.aka.oauthssospringboot.model.UserEntity;
import com.aka.oauthssospringboot.service.IUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserDetailsService userDetailsService;


    public UserController(IUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(UserEntity userEntity){

        logger.info("Creating new user");

        if (!validateUserData(userEntity)){
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        if (checkExistingUser(userEntity)){
            return ResponseEntity.badRequest().body("User already exists");
        }
        userDetailsService.createNewUser(userEntity);



        return ResponseEntity.ok().build();
    }

    private boolean checkExistingUser(UserEntity userEntity) {
        UserEntity fetched_UserEntity = userDetailsService.getUser(userEntity.getEmail());
        if (fetched_UserEntity == null) {
            return false;
        }
        return true;
    }

    private boolean validateUserData(UserEntity userEntity) {

        return false;
    }


}

