package com.caribedev.TaskManager.Infrastructure.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Tasks")
public class TaskEntity implements Serializable{
   
    private static final Long serialVersionUID = 0L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean completed;

    public TaskEntity() {
    }

    public TaskEntity(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public TaskEntity(Long id, String description, boolean completed) {
        this.id = id;
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
        final TaskEntity other = (TaskEntity) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description=" + description 
                + ", completed=" + completed + '}';
    }
    
   
    
}
