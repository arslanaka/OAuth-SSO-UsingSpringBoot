package com.aka.oauthssospringboot.controller;

import com.aka.oauthssospringboot.model.User;
import com.aka.oauthssospringboot.service.IUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    private final IUserDetailsService userDetailsService;


    public LoginController(IUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    public ResponseEntity<?> createNewUser(User user){
        if (!validateUserData(user)){
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        if (checkExistingUser(user)){
            return ResponseEntity.badRequest().body("User already exists");
        }
        userDetailsService.createNewUser(user);




    }

    private boolean checkExistingUser(User user) {
        User fetched_User = userDetailsService.getUser(user.getEmail());
        if (fetched_User == null) {
            return false;
        }
        return true;
    }

    private boolean validateUserData(User user) {

        return false;
    }


}

