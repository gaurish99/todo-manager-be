package com.gaurish.todo.controllers;

import com.gaurish.todo.model.Todo;
import com.gaurish.todo.services.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
@Slf4j
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        log.info("Received add todo request");
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.addTodo(todo));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String todoId, @RequestBody Todo todo) {
        log.info("Received update todo request");
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(todoId, todo));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Map<String,String>> deleteTodo(@PathVariable String todoId) {
        log.info("Received delete todo request");
        todoService.deleteTodo(todoId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo with ID " + todoId + " deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable String todoId) {
        log.info("Received get todo request");
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodo(todoId));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        log.info("Received get all todo request");
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }


}
