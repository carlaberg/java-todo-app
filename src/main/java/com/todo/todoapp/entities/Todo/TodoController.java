package com.todo.todoapp.entities.Todo;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {
    public final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("save")
    @CrossOrigin
    public String saveTodo(@RequestParam String message) {
        return todoService.saveTodo(message);
    }

    @GetMapping(path = "/get")
    @PreAuthorize("hasAuthority('READ')")
    public String getTodo(Principal principal) {
        return principal.getName();
    }    
}
