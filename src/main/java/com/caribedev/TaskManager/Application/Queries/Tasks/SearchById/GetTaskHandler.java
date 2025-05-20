package com.caribedev.TaskManager.Application.Queries.Tasks.SearchById;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Domain.Exceptions.EntityNotFoundException;
import com.caribedev.TaskManager.Domain.Ports.Repositories.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Service
public class GetTaskHandler implements IGetTask {

    @Autowired
    private final ITaskRepository tasRepository;

    public GetTaskHandler(ITaskRepository tasRepository) {
        this.tasRepository = tasRepository;
    }

    @Override
    public TaskResponse handle(GetTaskQuery query) {
        var result = tasRepository.findById(query.getTaskId());
        var task = result.orElseThrow(() -> new EntityNotFoundException("No existe la tarea: " + query.getTaskId()));
        return new TaskResponse(task.getId(), task.getDescription(), task.isCompleted());
    }

}
