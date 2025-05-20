package com.caribedev.TaskManager.Application.Commands.Tasks.Create;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface ICreateTask {

    TaskResponse handle(CreateTaskCommand command);
}
