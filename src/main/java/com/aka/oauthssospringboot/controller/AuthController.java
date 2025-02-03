package com.aka.oauthssospringboot.controller;

import com.aka.oauthssospringboot.model.dto.LoginRequest;
import com.aka.oauthssospringboot.model.dto.SignUpRequest;
import com.aka.oauthssospringboot.service.AuthService;
import com.aka.oauthssospringboot.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(ApiResponse.success("success",authService.login(request)));
    }
}
