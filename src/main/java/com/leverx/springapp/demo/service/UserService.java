package com.leverx.springapp.demo.service;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.model.UserRequest;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

public interface UserService {

    User create(@Valid UserRequest userRequest);

    Optional<User> get(Long id);

    Collection<User> getAll();

}
