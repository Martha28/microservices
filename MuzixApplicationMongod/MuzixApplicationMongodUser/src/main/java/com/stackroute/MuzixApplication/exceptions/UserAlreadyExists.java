package com.stackroute.MuzixApplication.exceptions;

public class UserAlreadyExists extends  Exception{
    private String message;

    public UserAlreadyExists(String message){
        super(message);
        this.message=message;
    }

}
