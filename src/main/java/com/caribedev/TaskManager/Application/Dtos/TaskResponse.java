package com.caribedev.TaskManager.Application.Dtos;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class TaskResponse {
    private final Long id;
    private final String description;
    private final boolean completed;

    public TaskResponse(Long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
    
    
}
