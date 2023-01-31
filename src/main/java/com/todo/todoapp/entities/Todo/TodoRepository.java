package com.todo.todoapp.entities.Todo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByCreatorId(String creatorId);
}