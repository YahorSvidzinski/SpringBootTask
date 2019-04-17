package com.leverx.springapp.demo.controller;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        userRepository.save(user);
        return ResponseEntity.created(location).build();
        //I want to stay with ResponseEntity to use builder
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<Optional<User>>(user, OK);
        }
        return new ResponseEntity(NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Optional<List<User>> users = Optional.ofNullable(userRepository.findAll());
         if (users.isPresent()) {
             return new ResponseEntity<Optional<List<User>>>(users, OK);
        } else {
             return new ResponseEntity(NOT_FOUND);
        }
    }
}
