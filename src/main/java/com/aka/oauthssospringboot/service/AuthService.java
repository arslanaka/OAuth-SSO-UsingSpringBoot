package com.aka.oauthssospringboot.service;

import com.aka.oauthssospringboot.config.JwtUtil;
import com.aka.oauthssospringboot.model.UserEntity;
import com.aka.oauthssospringboot.model.dto.LoginRequest;
import com.aka.oauthssospringboot.model.dto.SignUpRequest;
import com.aka.oauthssospringboot.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String signUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isEmpty() || !passwordEncoder.matches(request.getPassword(), userOptional.get().getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(request.getEmail());
    }
}

