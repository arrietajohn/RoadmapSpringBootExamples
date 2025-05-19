package com.caribedev.TaskManager.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class PreexistinEntityException extends RuntimeException{

    public PreexistinEntityException(String message) {
        super(message);
    }
    
}
