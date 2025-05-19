package com.caribedev.TaskManager.Infrastructure.Repositories;

import com.caribedev.TaskManager.Domain.Entities.Task;
import com.caribedev.TaskManager.Domain.Ports.Repositories.ITaskRepository;
import com.caribedev.TaskManager.Infrastructure.Persistence.Entities.TaskEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Repository
public class TaskRepositoryImp implements ITaskRepository {


    @Autowired
    private final IJpaTaskRepository jpaTaskRespository;

    public TaskRepositoryImp(IJpaTaskRepository jpaTaskRespository) {
        this.jpaTaskRespository = jpaTaskRespository;
    }

    @Override
    public Task save(Task task) {
        return toTask(jpaTaskRespository.save(toTaskEntity(task)));
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRespository.deleteById(id);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRespository
                .findById(id)
                .map(this::toTask);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRespository.findAll()
                .stream()
                .map(this::toTask).collect(Collectors.toList());
    }

    @Override
    public List<Task> findByCompleted() {
        return jpaTaskRespository.findByCompletedTrue()
                .stream()
                .map(this::toTask).collect(Collectors.toList());
    }

    @Override
    public List<Task> findByDescription(String description) {
        return jpaTaskRespository.findByDescription(description)
                .stream()
                .map(this::toTask)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findByCompletedWithDescription(String description) {
        return jpaTaskRespository.findByCompletedWithDescription(description)
                .stream()
                .map(this::toTask)
                .collect(Collectors.toList());
    }

    private Task toTask(TaskEntity entity) {
        var task = new Task();
        task.setId(entity.getId());
        task.setCompleted(entity.isCompleted());
        task.setDescription(entity.getDescription());
        return task;
    }

    private TaskEntity toTaskEntity(Task task) {
        var entity = new TaskEntity();
        entity.setCompleted(task.isCompleted());
        entity.setDescription(task.getDescription());
        return entity;
    }

    public IJpaTaskRepository getJpaTaskRespository() {
        return jpaTaskRespository;
    }

}
