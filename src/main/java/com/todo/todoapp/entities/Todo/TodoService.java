package com.todo.todoapp.entities.Todo;

public class TodoService implements ITodoService {

    private final TodoRepository logRepository;

    public TodoService(TodoRepository logRepository) {
        this.logRepository = logRepository;        
    }

    @Override
    public String saveTodo(String message) {
        if (message == null || message.length() == 0) {
            return "Hello my todo <3 sdf";
        }

        String result = String.format("%s has been saved to the database", message);

        Todo todo = new Todo();
        todo.setMessage(message);
        logRepository.save(todo);

        return result;
    }
    
}
