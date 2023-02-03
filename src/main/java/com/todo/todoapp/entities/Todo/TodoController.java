package com.todo.todoapp.entities.Todo;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    public final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    @CrossOrigin
    public Todo createTodo(@RequestBody Todo todo, Principal principal) {
        
        Todo todoRecord = new Todo();
        todoRecord.setCreatorId(principal.getName());
        todoRecord.setText(todo.getText());
        return todoService.createTodo(todoRecord);
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public Todo updateTodo(@PathVariable String id, @RequestBody UpdateTodoInput updateTodoInput) throws Exception {
            return todoService.updateTodo(id, updateTodoInput);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public String deleteTodo(@PathVariable String id) throws Exception {
            todoService.deleteTodo(id);
            return id;
    }

    @GetMapping("/all-todos")
    public List<Todo> getAllTodos(Principal principal) throws Exception {
        return todoService.getAll(principal.getName());
    }    

    @GetMapping(path = "/get")
    @PreAuthorize("hasAuthority('READ')")
    public String getTodo(Principal principal) {
        return principal.getName();
    }    
}
