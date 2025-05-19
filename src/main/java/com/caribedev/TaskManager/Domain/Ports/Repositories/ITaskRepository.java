package com.caribedev.TaskManager.Domain.Ports.Repositories;

import java.util.List;
import java.util.Optional;

import com.caribedev.TaskManager.Domain.Entities.Task;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface ITaskRepository {
    Task save(Task task);
    void deleteById(Long id);
    Optional<Task> findById(Long id);
    List<Task> findAll(); 
    List<Task> findByCompleted();
    List<Task> findByDescription(String description);
    List<Task> findByCompletedWithDescription(String description);
}

