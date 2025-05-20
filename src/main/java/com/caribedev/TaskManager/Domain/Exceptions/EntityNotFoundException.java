package com.caribedev.TaskManager.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
