package com.leverx.springapp.demo.controller;

import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    @Transactional
    @ApiOperation(value = "Creates new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created user"),
            @ApiResponse(code = 400, message = "Wrong request,user name length must be between 2 and 40")
    })
    public ResponseEntity<Void> create(@Valid @RequestBody User user) {
        userRepository.save(user);
        var location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves user by id from database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User was found", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all users from database", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Current list of users"),
    })
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
