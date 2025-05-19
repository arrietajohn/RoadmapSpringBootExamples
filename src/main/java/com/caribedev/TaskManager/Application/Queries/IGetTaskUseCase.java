package com.caribedev.TaskManager.Application.Queries;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Application.Queries.GetTaskQuery;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface IGetTaskUseCase {
    
    TaskResponse execute(GetTaskQuery query);
}
