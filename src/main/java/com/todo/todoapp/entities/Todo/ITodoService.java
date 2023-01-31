package com.todo.todoapp.entities.Todo;

import java.util.List;

public interface ITodoService {
    Todo createTodo(Todo todo);
    Todo updateTodo(String id, UpdateTodoInput input) throws Exception;
    void deleteTodo(String id) throws Exception;
    List<Todo> getAll(String userId) throws Exception;
}