package com.todo.service;

import java.util.Optional;
import java.util.UUID;

import com.todo.persistence.model.Task;

public interface TaskService {

    Iterable<Task> findAll();

    Optional<Task> findById(UUID id);

    Task save(Task task);

    void delete(UUID id);

}
