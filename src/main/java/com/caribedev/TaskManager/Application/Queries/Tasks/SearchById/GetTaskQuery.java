package com.caribedev.TaskManager.Application.Queries.Tasks.SearchById;

import com.caribedev.TaskManager.Domain.Exceptions.InvalidDomainValueException;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class GetTaskQuery {

   private final Long taskId;

    public GetTaskQuery(Long taskId) {
        if (taskId == null || taskId <= 0) {
            throw new InvalidDomainValueException("Task ID cannot be null or less than 1");
        }
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
    
}
