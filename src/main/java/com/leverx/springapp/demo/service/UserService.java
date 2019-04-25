package com.leverx.springapp.demo.service;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.model.UserRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

public interface UserService {

    @NotNull
    @Valid
    User create(UserRequest userRequest);

    Optional<User> get(Long id);

    Collection<User> getAll();

}
