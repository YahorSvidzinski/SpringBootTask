package com.leverx.springapp.demo.exception;

import com.leverx.springapp.demo.model.ErrorDetails;
import org.springframework.http.HttpHeaders;

import static com.leverx.springapp.demo.core.ErrorCodes.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.rmi.ServerError;

import static org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Error.class)
    public ResponseEntity<ErrorDetails> handleError(Error ex) {
        var errorDetails = new ErrorDetails(ex.getMessage(), SERVER_ERROR);
        return new ResponseEntity(errorDetails, INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        var errorDetails = new ErrorDetails(ex.getMessage(), INCORRECT_USER_INFO);
        return new ResponseEntity(errorDetails, status);
    }
}

