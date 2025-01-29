package com.vishalchauhan0688.journalApp.controller;

import com.vishalchauhan0688.journalApp.entity.JournalEntry;
import com.vishalchauhan0688.journalApp.entity.UserEntity;
import com.vishalchauhan0688.journalApp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<List<UserEntity>> findAllUser(){

        try{

            List<UserEntity> all = userService.findAll();

            if( all != null && !all.isEmpty()){
                return new ResponseEntity<>(all, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }
        catch (Exception e){
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<UserEntity> createUser(UserEntity newUser){
        try{
            UserEntity savedUser = userService.save(newUser);

            return new ResponseEntity<>(savedUser, HttpStatus.OK);

        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
