package com.demo.springsecurity.repository;

import com.demo.springsecurity.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailIgnoreCare(String username);

}
