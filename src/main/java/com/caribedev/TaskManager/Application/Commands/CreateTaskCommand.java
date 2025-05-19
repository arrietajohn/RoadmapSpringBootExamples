package com.caribedev.TaskManager.Application.Commands;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class CreateTaskCommand {
    private final boolean completed;
     @NotBlank(message = "Description cannot be blank")
    private final String description;

    public CreateTaskCommand(boolean completed, String description) {
        this.completed = completed;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
    
}
