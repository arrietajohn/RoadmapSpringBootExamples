package com.caribedev.TaskManager.Application.Queries.Tasks.SearchById;

import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Application.Queries.Tasks.SearchById.GetTaskQuery;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface IGetTask {
    
    TaskResponse handle(GetTaskQuery query);
}
