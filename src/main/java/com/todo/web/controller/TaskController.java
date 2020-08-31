package com.todo.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todo.persistence.converter.TaskConverter;
import com.todo.persistence.model.Constants;
import com.todo.persistence.model.Task;
import com.todo.service.TaskService;
import com.todo.web.dto.TaskDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskConverter taskConverter;

    @GetMapping(Constants.TASKS)
    public List<TaskDto> getTasks() {
       Iterable<Task> tasks = taskService.findAll();
       return taskConverter.convertToDto(tasks);
    }

    @GetMapping(Constants.TASK)
    public TaskDto getTask(@PathVariable("id") UUID id) {
        Task task = taskService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));
        return taskConverter.convertToDto(task);
    }

    @PostMapping(Constants.TASKS)
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
       Task task = taskConverter.convertFromDto(taskDto);
       return taskConverter.convertToDto(taskService.save(task));
    }

    @PatchMapping(Constants.TASK)
    public TaskDto updateProject(@PathVariable("id") UUID id, @RequestBody TaskDto updatedTaskDto) {
        Task task = taskConverter.convertFromDto(updatedTaskDto);
        return taskConverter.convertToDto(taskService.save(task)) ;
    }

    @DeleteMapping(Constants.TASK)
    public void deleteProject(@PathVariable("id") UUID id) {
        taskService.delete(id);
    }

}
