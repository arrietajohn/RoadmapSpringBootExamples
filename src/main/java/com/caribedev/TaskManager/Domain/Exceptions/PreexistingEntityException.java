package com.caribedev.TaskManager.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class PreexistingEntityException extends RuntimeException{

    public PreexistingEntityException(String message) {
        super(message);
    }
    
}
