package com.leverx.springapp.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserResponse {

    @ApiModelProperty(notes = "Unique id of user")
    private Long id;

    @ApiModelProperty(notes = "First name of user")
    private String firstName;

    @ApiModelProperty(notes = "Second name of user")
    private String secondName;

}
