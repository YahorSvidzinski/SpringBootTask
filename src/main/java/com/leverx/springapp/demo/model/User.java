package com.leverx.springapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    public static final int MAX_STRING_NAME_LENGTH = 40;
    public static final int MIN_STRING_NAME_LENGTH = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    @Size(min = MIN_STRING_NAME_LENGTH, max = MAX_STRING_NAME_LENGTH)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = MIN_STRING_NAME_LENGTH, max = MAX_STRING_NAME_LENGTH)
    @Column(name = "second_name")
    private String secondName;
}
