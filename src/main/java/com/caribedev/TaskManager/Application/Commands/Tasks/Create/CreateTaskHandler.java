package com.caribedev.TaskManager.Application.Commands.Tasks.Create;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Domain.Entities.Task;
import com.caribedev.TaskManager.Domain.Ports.Repositories.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Service
public class CreateTaskHandler implements ICreateTask {

    @Autowired
    private final ITaskRepository taskRepository;

    public CreateTaskHandler(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponse handle(CreateTaskCommand command) {
        var task = taskRepository.save(new Task(command.getDescription(),  command.isCompleted()));
        return new TaskResponse(task.getId(), task.getDescription(), task.isCompleted());
    }
    
    
    
}
