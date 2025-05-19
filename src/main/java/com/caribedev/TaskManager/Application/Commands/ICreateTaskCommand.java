package com.caribedev.TaskManager.Application.Commands;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface ICreateTaskCommand {

    TaskResponse execute(CreateTaskCommand command);
}
