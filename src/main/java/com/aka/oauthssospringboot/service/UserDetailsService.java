package com.aka.oauthssospringboot.service;

import com.aka.oauthssospringboot.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService implements IUserDetailsService {


    @Override
    public UserEntity createNewUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserEntity findUserById(Long id) {
        return null;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return List.of();
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return null;
    }
}
