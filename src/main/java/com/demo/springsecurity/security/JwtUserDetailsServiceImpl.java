package com.demo.springsecurity.security;

import com.demo.springsecurity.repository.UserRepository;
import com.demo.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailIgnoreCare(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No User found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
