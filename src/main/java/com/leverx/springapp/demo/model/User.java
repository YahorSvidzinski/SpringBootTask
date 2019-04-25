package com.leverx.springapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final int MAX_FIRST_NAME_LENGTH = 10;
    public static final int MIN_FIRST_NAME_LENGTH = 2;

    public static final int MAX_SECOND_NAME_LENGTH = 60;
    public static final int MIN_SECOND_NAME_LENGTH = 2;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Size(min = MIN_FIRST_NAME_LENGTH, max = MAX_FIRST_NAME_LENGTH)
    private String firstName;

    @NotNull
    @Size(min = MIN_SECOND_NAME_LENGTH, max = MAX_SECOND_NAME_LENGTH)
    private String secondName;
}
