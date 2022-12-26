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
    @CrossOrigin
    public GetTodoOutput showTodo(GetTodoInput input) {
        GetTodoOutput result = new GetTodoOutput();

        String outputMessage = todoService.showTodo(input.getMessage());

        result.setMessage(outputMessage);

        return result;
    }
}
