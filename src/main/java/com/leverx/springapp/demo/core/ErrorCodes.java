package com.leverx.springapp.demo.core;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorCodes {

    INCORRECT_USER_INFO("Wrong user params"),
    SERVER_ERROR("Server error");

    private final String msg;

}
