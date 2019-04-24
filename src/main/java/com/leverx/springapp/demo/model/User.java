package com.leverx.springapp.demo.model;

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
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final int MAX_NAME_LENGTH = 40;
    public static final int MIN_NAME_LENGTH = 2;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    private String firstName;

    @NotNull
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    private String secondName;
}
