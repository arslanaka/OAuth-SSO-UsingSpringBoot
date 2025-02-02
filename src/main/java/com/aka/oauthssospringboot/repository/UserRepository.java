package com.aka.oauthssospringboot.repository;

import com.aka.oauthssospringboot.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
