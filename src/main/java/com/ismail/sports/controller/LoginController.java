package com.ismail.sports.controller;
import com.ismail.sports.model.User;
import com.ismail.sports.repository.UserRepository;
import com.ismail.sports.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
public class LoginController<LoginRequest> {


    @Autowired
    private UserRepository userRepository;
    // Assuming UserRepository is your JPA repository for users
    @Autowired
    private  UserService userService;
    private LoginRequest loginRequest;

     @PostMapping("/login")
     public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
         String username = ((User) loginRequest).getUsername();
         String password = ((User) loginRequest).getPassword();
        

        @SuppressWarnings("static-access")
        boolean loginSuccess = userService.login(username,password);
         if (loginSuccess) {
             return ResponseEntity.ok().build();
         } else {
             return ResponseEntity.badRequest().build();
         }
     }

}

