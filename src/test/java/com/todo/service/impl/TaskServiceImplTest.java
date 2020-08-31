package com.todo.service.impl;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.persistence.model.Task;
import com.todo.persistence.repository.TaskRepository;
import com.todo.service.TaskService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void whenFindAll_expectTasksToBeReturned() {

        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("TEST");
        task.setStatus("IN PROGRESS");

        taskRepository.save(task);

        Iterable<Task> tasks = taskService.findAll();

        assertNotNull(tasks);
    }

    @Test
    void whenFindById_expectTaskToBeReturned() {

        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("TEST");
        task.setStatus("IN PROGRESS");

        taskRepository.save(task);



    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }



}