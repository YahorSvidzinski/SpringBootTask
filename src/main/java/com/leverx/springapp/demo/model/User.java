package com.leverx.springapp.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@ApiModel(description = "All details about user")
public class User {
    public static final int MAX_NAME_LENGTH = 40;
    public static final int MIN_NAME_LENGTH = 2;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @ApiModelProperty(notes = "The database generated user ID")
    private Long id;

    @NotNull
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    @ApiModelProperty(notes = "User first name")
    private String firstName;

    @NotNull
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    @ApiModelProperty(notes = "User last name")
    private String secondName;
}
