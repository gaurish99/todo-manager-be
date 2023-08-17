package com.gaurish.todo.services;

import com.gaurish.todo.model.Todo;

import java.util.List;

public interface TodoService {
    Todo addTodo(Todo todo);

    Todo updateTodo(String id, Todo todo);

    void deleteTodo(String id);

    List<Todo> getAllTodos();

    Todo getTodo(String id);
}
