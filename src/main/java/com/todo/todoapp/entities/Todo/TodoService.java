package com.todo.todoapp.entities.Todo;

import java.util.List;
import java.util.Optional;

public class TodoService implements ITodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;        
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(String id, UpdateTodoInput updateTodoInput) throws Exception {
        Optional<Todo> maybeTodo = todoRepository.findById(id);
        
        if (maybeTodo.isPresent()) {
            Todo todo = maybeTodo.get();
            todo.setText(updateTodoInput.getText());
            return todoRepository.save(todo);
        } else {
            throw new Exception();

        }
    }

    @Override
    public void deleteTodo(String id) throws Exception {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getAll(String userId) throws Exception {
        return todoRepository.findByCreatorId(userId);
    }
    
}
