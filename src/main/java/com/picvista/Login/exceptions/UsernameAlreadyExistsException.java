package com.picvista.Login.exceptions;

public class UsernameAlreadyExistsException extends GenericException{
    public UsernameAlreadyExistsException(String message){
        super(message);
    }
}
