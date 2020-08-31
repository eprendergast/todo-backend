package com.todo.web.dto;

import java.util.UUID;

import com.todo.persistence.model.Status;

import lombok.Data;

@Data
public class TaskDto {

    private UUID id;
    private String description;
    private Status status;

}
