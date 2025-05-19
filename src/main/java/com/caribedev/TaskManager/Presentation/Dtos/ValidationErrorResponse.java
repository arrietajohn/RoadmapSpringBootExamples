package com.caribedev.TaskManager.Presentation.Dtos;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse {

    private final String code = "VALIDATION_FAILED";
    private final String message = "Uno o más campos contienen errores";
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final Map<String, String> errors;

    public ValidationErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
