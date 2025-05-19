package com.caribedev.TaskManager.Presentation.Dtos;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private String code; 
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }   

    public void setMessage(String message) {
        this.message = message;
    }   

    public String getCode() {
        return code;
    }   

    public void setCode(String code) {
        this.code = code;
    }   

    public LocalDateTime getTimestamp() {
        return timestamp;
    }   

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }   

}
