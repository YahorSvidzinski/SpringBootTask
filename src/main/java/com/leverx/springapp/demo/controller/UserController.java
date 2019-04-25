package com.leverx.springapp.demo.controller;

import com.leverx.springapp.demo.model.ErrorDetails;
import com.leverx.springapp.demo.model.User;
import com.leverx.springapp.demo.model.UserRequest;
import com.leverx.springapp.demo.model.UserResponse;
import com.leverx.springapp.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

import static javax.servlet.http.HttpServletResponse.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Creates new user")
    @ApiResponses(value = {
            @ApiResponse(code = SC_CREATED, message = "Successfully created user"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "Wrong request", response = ErrorDetails.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Server error")
    })
    @ResponseStatus(CREATED)
    public ResponseEntity<Void> create(@Valid @RequestBody UserRequest userRequest) {
        var user = userService.create(userRequest);
        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves user")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "User was found", response = UserResponse.class),
            @ApiResponse(code = SC_NOT_FOUND, message = "User not found"),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Server error")
    })
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(userService.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all users", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Current list of users"),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Server error")
    })
    public ResponseEntity<Collection<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
