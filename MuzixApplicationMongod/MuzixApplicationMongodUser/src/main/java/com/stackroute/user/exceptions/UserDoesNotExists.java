package com.stackroute.user.exceptions;

public class UserDoesNotExists extends  Exception {
    private String message;

    public UserDoesNotExists(String message){
        super(message);
        this.message=message;
    }

}
