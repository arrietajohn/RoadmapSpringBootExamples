package com.caribedev.TaskManager.Domain.Exceptions;

public class InvalidDomainValueException extends RuntimeException {

    public InvalidDomainValueException(String message) {
        super(message);
    }

}
