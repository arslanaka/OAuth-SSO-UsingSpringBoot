package com.aka.oauthssospringboot.service;

import com.aka.oauthssospringboot.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserDetailsService {


    UserEntity createNewUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

    void deleteUser(Long id);

    UserEntity findUserById(Long id);

    List<UserEntity> findAllUsers();

    UserEntity findUserByEmail(String email);







}
