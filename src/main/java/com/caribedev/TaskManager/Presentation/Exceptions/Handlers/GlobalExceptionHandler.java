package com.caribedev.TaskManager.Presentation.Exceptions.Handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.caribedev.TaskManager.Domain.Exceptions.InvalidDomainValueException;
import com.caribedev.TaskManager.Domain.Exceptions.NotFoundEntityException;
import com.caribedev.TaskManager.Domain.Exceptions.PreexistinEntityException;
import com.caribedev.TaskManager.Presentation.Dtos.ErrorResponse;
import com.caribedev.TaskManager.Presentation.Dtos.ValidationErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(new ValidationErrorResponse(errors));
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ErrorResponse> handleMissingPathVariable(MissingPathVariableException ex) {
        String nombre = ex.getVariableName();
        String mensaje = "Falta el parámetro requerido en la URL: " + nombre;

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(mensaje, "MISSING_PATH_VARIABLE"));
    }

    @ExceptionHandler({InvalidDomainValueException.class,
        HttpRequestMethodNotSupportedException.class,
        MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleValidationExceptions(Exception e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage(), "ERROR_INVALID_DOMAIN_VALUE"));

    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundEntityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage(), "ERROR_NOT_ENTITY_FOUND"));
    }

    @ExceptionHandler(PreexistinEntityException.class)
    public ResponseEntity<ErrorResponse> handlerExistingEntityException(PreexistinEntityException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(e.getMessage(), "ERROR_ENTITY_ALREADY_EXISTS"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Internal Error server", "ERROR_INTERNAL_SERVER"));

    }

}
