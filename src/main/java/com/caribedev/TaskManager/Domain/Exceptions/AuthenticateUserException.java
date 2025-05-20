package com.caribedev.TaskManager.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class AuthenticateUserException extends RuntimeException{

    public AuthenticateUserException() {
        super("Invalid username or password");
    }
    
}
