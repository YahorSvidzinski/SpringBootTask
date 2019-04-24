package com.leverx.springapp.demo.exception;

import com.leverx.springapp.demo.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ErrorDetails> handleError(InternalServerError ex, WebRequest webRequest) {
        String message = "Server error";
        ErrorDetails errorDetails = new ErrorDetails(message, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(errorDetails, errorDetails.getHttpStatus());
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<ErrorDetails> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        String message = "Wrong user names,length must be between 2 and 40";
        ErrorDetails errorDetails =
                new ErrorDetails(message, HttpStatus.BAD_REQUEST);
        return new ResponseEntity(errorDetails, errorDetails.getHttpStatus());
    }
}

