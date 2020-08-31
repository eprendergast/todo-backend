package com.todo.web.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.persistence.model.Task;
import com.todo.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> getTasks() {
       return taskService.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTask(@PathVariable("id") UUID id) {
        return taskService.findById(id);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
       return taskService.save(task);
    }

    @PatchMapping("/tasks/{id}")
    public Task updateProject(@PathVariable("id") UUID id, @RequestBody Task updatedTask) {
        return taskService.save(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteProject(@PathVariable("id") UUID id) {
        taskService.delete(id);
    }

}
