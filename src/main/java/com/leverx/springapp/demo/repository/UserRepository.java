package com.leverx.springapp.demo.repository;

import com.leverx.springapp.demo.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    Collection<User> findAll();

}
