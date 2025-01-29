package com.vishalchauhan0688.journalApp.service;

import com.vishalchauhan0688.journalApp.entity.UserEntity;
import com.vishalchauhan0688.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity save(UserEntity newUser){

        return userRepository.save(newUser);

    }

    public Optional<UserEntity> getById(ObjectId id){

        return userRepository.findById(id);
    }
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    public void deleteById( ObjectId id){

        userRepository.deleteById(id);
    }
}
