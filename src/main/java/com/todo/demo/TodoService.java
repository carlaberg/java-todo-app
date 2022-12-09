package com.todo.demo;

public class TodoService implements ITodoService {

    private final LogRepository logRepository;

    public TodoService(LogRepository logRepository) {
        this.logRepository = logRepository;        
    }

    @Override
    public String showTodo(String message) {
        if (message == null || message.length() == 0) {
            return "Hello my todo <3 sdf";
        }

        String result = String.format("%s my todo <3", message);

        Log log = new Log();
        log.setMessage(message);
        logRepository.save(log);

        return result;
    }
    
}
