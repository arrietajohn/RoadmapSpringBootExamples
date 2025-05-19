package com.caribedev.TaskManager.Application.Queries;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Application.Queries.GetTaskQuery;
import com.caribedev.TaskManager.Domain.Exceptions.NotFoundEntityException;
import com.caribedev.TaskManager.Domain.Ports.Repositories.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Service
public class GetTaskQueryHandler implements IGetTaskUseCase {

    @Autowired
    private final ITaskRepository tasRepository;

    public GetTaskQueryHandler(ITaskRepository tasRepository) {
        this.tasRepository = tasRepository;
    }

    @Override
    public TaskResponse execute(GetTaskQuery query) {
        var result = tasRepository.findById(query.getTaskId());
        var task = result.orElseThrow(() -> new NotFoundEntityException("No existe la tarea: " + query.getTaskId()));
        return new TaskResponse(task.getId(), task.getDescription(), task.isCompleted());
    }

}
