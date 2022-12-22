package com.todo.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {
    public  final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("index")
    @CrossOrigin(origins = {"http://localhost:3010", "http://164.90.208.25:3010"})
    public GetTodoOutput showTodo(GetTodoInput input) {
        GetTodoOutput result = new GetTodoOutput();

        String outputMessage = todoService.showTodo(input.getMessage());

        result.setMessage(outputMessage);

        return result;
    }
}
