package com.demo.springsecurity.controller;

import com.demo.springsecurity.domain.Response;
import com.demo.springsecurity.model.User;
import com.demo.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreLoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public ResponseEntity<Response> registration(@RequestBody User user) {
        User dbUser = userService.save(user);
        if (dbUser != null) {
            return new ResponseEntity<Response>(new Response("user is saved successfully"), HttpStatus.OK);
        }
        return null;
    }
}
