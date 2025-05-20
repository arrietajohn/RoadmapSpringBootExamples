package com.caribedev.TaskManager.Presentation.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caribedev.TaskManager.Application.Commands.Tasks.Create.CreateTaskCommand;
import com.caribedev.TaskManager.Application.Commands.Tasks.Create.ICreateTask;
import com.caribedev.TaskManager.Application.Dtos.TaskResponse;
import com.caribedev.TaskManager.Application.Queries.Tasks.SearchById.GetTaskQuery;
import com.caribedev.TaskManager.Application.Queries.Tasks.SearchById.IGetTask;

import jakarta.validation.Valid;



/**
 *
 * @author John Carlos Arrieta Arrieta
 */

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final ICreateTask createTaskCommand;
    private final IGetTask getTaskUseCase;

    public TaskController(ICreateTask createTaskCommand, IGetTask getTaskUseCase) {
        this.getTaskUseCase = getTaskUseCase;
        this.createTaskCommand = createTaskCommand;
    }

   @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskCommand command) {
        TaskResponse taskResponse = createTaskCommand.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);    
    }   

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> get(@Valid @PathVariable Long id) {
        TaskResponse taskResponse = getTaskUseCase.handle(new GetTaskQuery(id));
        return ResponseEntity.ok(taskResponse);
    }

}
