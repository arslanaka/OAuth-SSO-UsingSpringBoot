package com.aka.oauthssospringboot.controller;

import com.aka.oauthssospringboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> requestBody) {
        try {
            // Extract email and password from the request body
            Map<String, Object> formData = (Map<String, Object>) requestBody;
            String email = (String) formData.get("email");
            String password = (String) formData.get("password");

            User user = userDetailsService.loadUserByUsername(email);

            if (user == null) {
                throw new UsernameNotFoundException("Username not found: " + email);
            }

            if (!user.getPassword().equals(password)) {
                throw new IncorrectCredentialsException("Invalid credentials");
            }

            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("status", "Logged in successfully!");
            }});

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).jsonBody(Map.of(
                    "error", e.getMessage()
            ));
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        try {
            userDetailsService.logoutSuccess();
            return ResponseEntity.ok(Map.of("status", "Logged out successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).jsonBody(Map.of(
                    "error", e.getMessage()
            ));
        }
    }
}

