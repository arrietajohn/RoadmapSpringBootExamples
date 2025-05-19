package com.caribedev.TaskManager.Application.Services;

import org.springframework.stereotype.Service;

import com.caribedev.TaskManager.Domain.Ports.Repositories.ITaskRepository;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Service
public class TaskService {
    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    

}
