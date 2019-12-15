package com.demo.springsecurity.service;

import com.demo.springsecurity.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User getUserByEmail(String email);
}
