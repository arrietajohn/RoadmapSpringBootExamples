package com.caribedev.TaskManager.Presentation.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caribedev.TaskManager.Application.Commands.CreateTaskCommand;
import com.caribedev.TaskManager.Application.Commands.ICreateTaskCommand;
import com.caribedev.TaskManager.Application.Dtos.TaskResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.caribedev.TaskManager.Application.Queries.GetTaskQuery;
import com.caribedev.TaskManager.Application.Queries.IGetTaskUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author John Carlos Arrieta Arrieta
 */

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final ICreateTaskCommand createTaskCommand;
    private final IGetTaskUseCase getTaskUseCase;

    public TaskController(ICreateTaskCommand createTaskCommand, IGetTaskUseCase getTaskUseCase) {
        this.getTaskUseCase = getTaskUseCase;
        this.createTaskCommand = createTaskCommand;
    }

   @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskCommand command) {
        TaskResponse taskResponse = createTaskCommand.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);    
    }   

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> get(@Valid @PathVariable Long id) {
        TaskResponse taskResponse = getTaskUseCase.execute(new GetTaskQuery(id));
        return ResponseEntity.ok(taskResponse);
    }

}
