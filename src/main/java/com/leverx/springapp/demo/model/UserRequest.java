package com.leverx.springapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.leverx.springapp.demo.model.User.*;

@Data
@AllArgsConstructor
public class UserRequest {

    @NotNull
    @Size(min = MIN_FIRST_NAME_LENGTH, max = MAX_FIRST_NAME_LENGTH)
    private String firstName;

    @NotNull
    @Size(min = MIN_SECOND_NAME_LENGTH, max = MAX_SECOND_NAME_LENGTH)
    private String secondName;

}
