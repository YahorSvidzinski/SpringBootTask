package com.leverx.springapp.demo.model;

import com.leverx.springapp.demo.core.ErrorCodes;
import lombok.Value;

@Value
public class ErrorDetails {

    private String message;
    private String errorCode;

    public ErrorDetails(String message, ErrorCodes errorCodes) {
        this.message = message;
        this.errorCode = errorCodes.getMsg();
    }


}
