package com.todo.todoapp.entities.Todo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Todo {
    @Id
    private String id;
    private String creatorId;
    private String text;
}