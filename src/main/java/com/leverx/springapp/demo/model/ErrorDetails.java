package com.leverx.springapp.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class ErrorDetails {
    @ApiModelProperty(notes = "User names length must be between 2 and 40")
    private String message;
    private HttpStatus httpStatus;

}
