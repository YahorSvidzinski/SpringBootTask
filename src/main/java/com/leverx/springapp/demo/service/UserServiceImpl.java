package com.leverx.springapp.demo.service;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.model.UserRequest;
import com.leverx.springapp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User create(UserRequest userRequest) {
        var user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true, isolation = REPEATABLE_READ)
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true, isolation = REPEATABLE_READ)
    public Collection<User> getAll() {
        return userRepository.findAll();
    }
}
