package com.todo.persistence.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.todo.persistence.model.Task;

public interface TaskRepository extends CrudRepository<Task, UUID> {
}
