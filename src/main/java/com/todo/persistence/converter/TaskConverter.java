package com.todo.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.todo.persistence.model.Task;
import com.todo.web.dto.TaskDto;

@Component
public class TaskConverter {

    public List<TaskDto> convertToDto(Iterable<Task> tasks) {
        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.forEach(task -> taskDtos.add(convertToDto(task)) );
        return taskDtos;
    }

    public TaskDto convertToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

    public Task convertFromDto(TaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return task;
    }

}
