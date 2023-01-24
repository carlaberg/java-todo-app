package com.todo.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todo.todoapp.entities.Todo.ITodoService;
import com.todo.todoapp.entities.Todo.TodoRepository;
import com.todo.todoapp.entities.Todo.TodoService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public TodoRepository logRepository;

	@Bean
	public ITodoService todoService() {
		return new TodoService(logRepository);
	}

}
