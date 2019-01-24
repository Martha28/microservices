package com.stackroute.user.Controller;

import com.stackroute.user.exceptions.NullValuesPassed;
import com.stackroute.user.exceptions.UserAlreadyExists;
import com.stackroute.user.exceptions.UserDoesNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists")
    @ExceptionHandler(UserAlreadyExists.class)
    public void UserAlreadyExists(UserAlreadyExists e) {

    }

    @ExceptionHandler(UserDoesNotExists.class)
    public ResponseEntity<?> UserDoesNotExists(UserDoesNotExists e) {
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="List is empty")
    @ExceptionHandler(NullValuesPassed.class)
    public void UserListIsEmpty(NullValuesPassed e) {
    }
}
