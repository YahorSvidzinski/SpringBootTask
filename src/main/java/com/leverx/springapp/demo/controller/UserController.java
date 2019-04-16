package com.leverx.springapp.demo.controller;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public ResponseEntity createUser(@RequestBody User user) {
        /*if (user.getFirstName().length() < Constants.MIN_STRING_LENGTH
                && user.getSecondName().length() < Constants.MIN_STRING_LENGTH
                && user.getFirstName().length() > Constants.MAX_STRING_LENGTH
                && user.getSecondName().length() > Constants.MAX_STRING_LENGTH) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }*/
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        if (userRepository.findById(id).isPresent()) {
            return new ResponseEntity<Object>(userRepository.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        if (userRepository.findAll().isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Object>(userRepository.findAll(), HttpStatus.OK);
    }
}
