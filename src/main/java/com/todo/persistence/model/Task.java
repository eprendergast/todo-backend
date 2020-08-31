package com.todo.persistence.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private Status status;

}
