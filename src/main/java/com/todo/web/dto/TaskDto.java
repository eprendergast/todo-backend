package com.todo.web.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class TaskDto {

    private UUID id;
    private String description;
    private String status;

}
