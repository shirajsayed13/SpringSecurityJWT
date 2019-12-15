package com.demo.springsecurity.service;

import com.demo.springsecurity.repository.UserRepository;
import com.demo.springsecurity.model.User;
import com.demo.springsecurity.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCare(email);
    }
}
