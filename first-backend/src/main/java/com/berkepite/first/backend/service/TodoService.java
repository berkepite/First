package com.berkepite.first.backend.service;

import org.springframework.security.oauth2.jwt.Jwt;

import com.berkepite.first.backend.model.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO createTodo(Jwt jwt, TodoDTO todo);

    List<TodoDTO> getAllTodos(Jwt jwt);

    TodoDTO getTodo(Jwt jwt, Long todoId);

    TodoDTO updateTodo(Jwt jwt, Long todoId, TodoDTO todoDTO);
}
