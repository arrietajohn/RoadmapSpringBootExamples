package com.caribedev.TaskManager.Domain.Entities;

import java.util.Objects;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class Task {
 
    private Long id;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(Long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description=" + description + ", completed=" + completed + '}';
    }
}
