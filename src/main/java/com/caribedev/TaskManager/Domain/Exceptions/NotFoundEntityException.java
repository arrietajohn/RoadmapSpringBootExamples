package com.caribedev.TaskManager.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class NotFoundEntityException extends RuntimeException{

    public NotFoundEntityException(String message) {
        super(message);
    }
    
}
