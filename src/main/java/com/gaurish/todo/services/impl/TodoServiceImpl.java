package com.gaurish.todo.services.impl;

import com.gaurish.todo.exceptions.TodoNotFoundException;
import com.gaurish.todo.model.Todo;
import com.gaurish.todo.repository.TodoRepository;
import com.gaurish.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString().substring(0,4));
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(String id, Todo todo) {

        Todo oldTodo = todoRepository.findById(id).orElseThrow(
            () ->
                new TodoNotFoundException("Todo with the given ID " + id + " does not exist"));
        oldTodo.setTitle(todo.getTitle());
        oldTodo.setSummary(todo.getSummary());
        oldTodo.setComplete(todo.isComplete());
        Todo newTodo = oldTodo;
        return todoRepository.save(newTodo);
    }

    @Override
    public void deleteTodo(String id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
            () ->
                new TodoNotFoundException("Todo with the given ID " + id + " does not exist"));
        todoRepository.delete(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(String id) {
        return todoRepository.findById(id).orElseThrow(
            () ->
                new TodoNotFoundException("Todo with the given ID " + id + " does not exist"));
    }
}
